package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import security.AuthenticationSupport;
import security.IAuthenticationSupport;

/**
 * Created by Alisa on 5/15/2017.
 */
@Aspect
@Configurable
public class SecurityAspect {

    @Autowired
    private AuthenticationSupport authenticationSupport;

    public SecurityAspect(){

    }

    @Pointcut("execution(* mvc.controllers.*.update(..))")
    public void authenticationRequired() { }

    @Before("authenticationRequired()")
    public void authenticate() {
        System.out.println("Authentication started.");
        this.authenticationSupport.authenticate();
    }

    public IAuthenticationSupport getAuthenticationSupport() {
        return authenticationSupport;
    }

    public void setAuthenticationSupport(AuthenticationSupport authenticationSupport) {
        this.authenticationSupport = authenticationSupport;
    }
}