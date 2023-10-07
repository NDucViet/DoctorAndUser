package UserManager.Repository;

import UserManager.DataAccess.Function;


public class UserRepository implements IUserRepository{

    Function f = new Function();

    @Override
    public void createNewAccount() {
        f.createNewAccount();
    }

    @Override
    public void loginSystem() {
       f.loginSystem();
    }

   
    
}
