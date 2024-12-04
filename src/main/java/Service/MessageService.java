package Service;

import Model.Account;
import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }
    
    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    //TODO: Create New Message using messageDAO
    public Message newMessage (String Message_Text, Message message){
        if ((Message_Text.isBlank() == true || Message_Text.length() > 255)) return null;
        else return messageDAO.newMessage(Message_Text, message);
    } 

    //TODO: Get All Messages using messageDAO
    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    //TODO: Get One Message Given Message Id using messageDAO
    public Message getMessageByMessageId (int message_id){
        return messageDAO.getMessageByMessageId(message_id);
    }

    //TODO: Delete a Message Given Message Id using messageDAO
    public Message deleteMessageByMessageId (int message_id){
        if (messageDAO.getMessageByMessageId(message_id) != null) return messageDAO.deleteMessageByMessageId(message_id);
        else return null;
    }

    //TODO: Update Message Given Message Id using messageDAO
    public Message updateMessageByMessageId (int message_id){
        if (messageDAO.getMessageByMessageId(message_id) != null) return messageDAO.updateMessageByMessageId(message_id);
        else return null;
    }

    //TODO: Get All Messages From User Given Account Id using messageDAO
    public List<Message> getAllMessagesGivenAccountId(int account_id) {
        return messageDAO.getAllMessagesGivenAccountId(account_id);
    }
}
