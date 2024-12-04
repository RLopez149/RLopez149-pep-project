package Service;

import Model.Account;
import Model.Message;
import DAO.AccountDAO;
import DAO.MessageDAO;

import java.util.List;

public class AccountService {
    AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }
    
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    //TODO: Create user with accountDAO
    public Account userRegistration(String user, String pass, Account account){
        if (user.isBlank() == true || pass.length() < 4 || pass.length() > 255) return null;
        else return accountDAO.userRegistration(user, pass, account);
    }

    //TODO: Login using accountDAO
    public Account userLogin(String user, String pass){
        return accountDAO.userLogin(user, pass);
    }
}