package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Alisa on 5/15/2017.
 */
@Component
public class AuthenticationSupport implements IAuthenticationSupport {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @Override
    public void authenticate() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication != null) {
            return;
        }

        try {
            Authentication authenticationToken = loginService.getAuthenticationToken();
            authentication = authenticationManager
                    .authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception e){
            System.err.println("Username or password incorrect!");
        }
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ILoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
