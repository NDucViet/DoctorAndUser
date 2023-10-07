package UserManager.controller;


import UserManager.Repository.UserRepository;
import UserManager.view.Menu;

public class UserController extends Menu{
    UserRepository userRepository = new UserRepository();
    static String[] option = { "Create a new account.",
            " Login system.",
            "Exit" };

    public UserController(){
        super("User Management System", option);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                userRepository.createNewAccount();
                break;
            case 2:
                userRepository.loginSystem();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
