package Service;

import Model.Account;
import Model.Message;
import DAO.SocialMediaDAO;

import java.util.List;

public class SocialMediaService {
    SocialMediaDAO socialMediaDAO;

    public SocialMediaService(){
        socialMediaDAO = new SocialMediaDAO();
    }
    
    public SocialMediaService(SocialMediaDAO socialMediaDAO){
        this.socialMediaDAO = socialMediaDAO;
    }

    //TODO: User Registration using SocialMediaDAO

    //TODO: Login using SocialMediaDAO

    //TODO: Create New Message using SocialMediaDAO

    //TODO: Get All Messages using SocialMediaDAO
    public List<Message> getAllMessages() {
        return socialMediaDAO.getAllMessages();
    }

    //TODO: Get One Message Given Message Id using SocialMediaDAO

    //TODO: Delete a Message Given Message Id using SocialMediaDAO

    //TODO: Update Message Given Message Id using SocialMediaDAO

    //TODO: Get All Messages From User Given Account Id using SocialMediaDAO
}
