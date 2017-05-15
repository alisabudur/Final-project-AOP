package security;

import org.aspectj.lang.JoinPoint;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.util.PatternMatchUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Alisa on 5/15/2017.
 */
public class MappingBasedSecurityMetadataSource implements SecurityMetadataSource {

    private Map<String, String> mapping;

    public List<ConfigAttribute> getAttributes(Object jp) {
        String methodName = ((JoinPoint) jp).getSignature().getName();
        for (String pattern : mapping.keySet()) {
            if (PatternMatchUtils.simpleMatch(pattern, methodName)) {
                String role = mapping.get(pattern);
                return SecurityConfig.createList(role);
            }
        }
        throw new IllegalArgumentException("Unknown mapping for " + methodName);
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class clazz) {
        return clazz.isAssignableFrom(JoinPoint.class);
    }

    public void setRoleMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
