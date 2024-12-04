package Controller;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;
import java.util.logging.Handler;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(){
        this.accountService = new AccountService();
        this.messageService = new MessageService();
    }
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.post("/register", this::registerHandler);
        app.post("/login", this:: loginHandler);
        app.post("/messages", this::postMessageHandler);
        app.get("/messages", this::getMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByMessageIDHandler);
        app.delete("/messages/{message_id}", this::deleteMessageByIDHandler);
        app.patch("/messages/{message_id}", this::patchMessageByIDHandler);
        app.get("/accounts/{account_id}/messages", this::getMessagesByAccountIDHandler);

        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void registerHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);

        String user = account.getUsername();
        String pass = account.getPassword();

        Account registration = accountService.userRegistration(user, pass, account);
        if(registration != null) ctx.json(mapper.writeValueAsString(registration));
        else ctx.status(400);
    }

    private void loginHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);

        String user = account.getUsername();
        String pass = account.getPassword();

        Account login = accountService.userLogin(user, pass);
        if(login != null) ctx.json(mapper.writeValueAsString(login));
        else ctx.status(401);
    }

    private void postMessageHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);

        String Message_Text = message.getMessage_text();

        Message newMessage = messageService.newMessage(Message_Text, message);
        if(newMessage != null) ctx.json(mapper.writeValueAsString(newMessage));
        else ctx.status(400);
    }

    private void getMessagesHandler(Context ctx) throws JsonProcessingException{
        List<Message> messages = messageService.getAllMessages();
        ctx.json(messages);
    }

    private void getMessageByMessageIDHandler(Context ctx) throws JsonProcessingException{
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        Message getMessage = messageService.getMessageByMessageId(message_id);

        if (getMessage != null)ctx.json(getMessage);
        else ctx.status(200);
    }

    private void deleteMessageByIDHandler(Context ctx) throws JsonProcessingException{
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        Message deletedMessage = messageService.deleteMessageByMessageId(message_id);
        if (deletedMessage != null) ctx.json(deletedMessage);
        else ctx.status(200);
    }
    private void patchMessageByIDHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);

        String updatedMessage = message.getMessage_text();
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));

        Message update = messageService.updateMessageByMessageId(message_id, updatedMessage);
        if(update != null) ctx.json(mapper.writeValueAsString(update));
        else ctx.status(400);
    }

    private void getMessagesByAccountIDHandler(Context ctx) throws JsonProcessingException{
        int account_id = Integer.parseInt(ctx.pathParam("account_id"));
        List<Message> messages = messageService.getAllMessagesGivenAccountId(account_id);
        ctx.json(messages);
    }
}