package UserManager.DataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import UserManager.common.Valid;
import UserManager.model.User;

public class Function {
    Valid v = new Valid();
    public void createNewAccount() {
        //check file data exist or not
        if (!v.checkFileExist()) {
            return;
        }
        String username = v.checkInputUsername();
        String password = v.checkInputPassword();
        User user = new User(username, password);
        //check username exist or not
        if (!v.checkUsernameExist(username)) {
            System.err.println("Username exist.");
            return;
        }
        addAccountData(user);
    }

    //login system
    public void loginSystem() {
        //check file data exist or not
        if (!v.checkFileExist()) {
            return;
        }
        String username = v.checkInputUsername();
        String password = v.checkInputPassword();
        //check username exist or not
        if (!v.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Password incorrect.");
            }
            System.err.println("Login success.");
        }
    }

    //write new account to data
    public void addAccountData(User user) {
        File file = new File("D:/user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(user.getUserName() + ";" + user.getPassword() + "\n");
            fileWriter.close();
            System.err.println("Create successly.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //get password by username
    public String passwordByUsername(String username) {
        File file = new File("D:/user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
