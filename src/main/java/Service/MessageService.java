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

    //TODO: User Registration using SocialMediaDAO

    //TODO: Login using SocialMediaDAO

    //TODO: Create New Message using SocialMediaDAO
    public Message newMessage (String Message_Text, Message message){
        if ((Message_Text == null || Message_Text == "" || Message_Text.length() > 255)) return null;
        else return messageDAO.newMessage(Message_Text, message);
    } 

    //TODO: Get All Messages using SocialMediaDAO
    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    //TODO: Get One Message Given Message Id using SocialMediaDAO
    public Message getMessageByMessageId (int message_id){
        return messageDAO.getMessageByMessageId(message_id);
    }

    //TODO: Delete a Message Given Message Id using SocialMediaDAO

    //TODO: Update Message Given Message Id using SocialMediaDAO

    //TODO: Get All Messages From User Given Account Id using SocialMediaDAO
    public List<Message> getAllMessagesGivenAccountId(int account_id) {
        return messageDAO.getAllMessagesGivenAccountId(account_id);
    }
}
