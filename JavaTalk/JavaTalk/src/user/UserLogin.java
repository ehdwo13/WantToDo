package user;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class UserLogin {

    public void login(Scanner sc) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserLoginService uls = new UserLoginService();
        String isCorrect = "";

        while (!isCorrect.equals("pass")) {
            System.out.println("Type id for login (or 'q' to quit):");
            String id = sc.nextLine();
            if (id.equals("q")) {
                System.out.println("Exiting login process.");
                break;
            }
            
            System.out.println("Type password (or 'q' to quit):");
            String password = sc.nextLine();
            if (password.equals("q")) {
                System.out.println("Exiting login process.");
                break;
            }

            isCorrect = uls.match(id, password);

            if (isCorrect.equals("wrongId")) {
                System.out.println("There's no matched id" + System.lineSeparator() + "try other id");
            } else if (isCorrect.equals("wrongPassword")) {
                System.out.println("Incorrect password" + System.lineSeparator() + "try again");
            } else if (isCorrect.equals("pass")) {
                System.out.println("Login successful");
            }
        }
    }
}
