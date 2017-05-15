package security;

import org.springframework.security.core.Authentication;

/**
 * Created by Alisa on 5/15/2017.
 */
public interface ILoginService {
    Authentication getAuthenticationToken();
}
