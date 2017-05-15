package security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.swing.*;

/**
 * Created by Alisa on 5/15/2017.
 */
public class LoginService implements ILoginService {

    public Authentication getAuthenticationToken() {
        String userName= JOptionPane.showInputDialog("Username:");
        String password=JOptionPane.showInputDialog("Password:");

        return new UsernamePasswordAuthenticationToken(userName, password);
    }
}