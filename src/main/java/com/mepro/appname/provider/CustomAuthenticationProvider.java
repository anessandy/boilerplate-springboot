package com.mepro.appname.provider;

import com.mepro.appname.dao.LoginDao;
import com.mepro.appname.dto.UserInfoDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private LoginDao loginRepository;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            List<UserInfoDto> userList = loginRepository.getListUserInfo(username, password);

            if (userList.isEmpty()) {
                throw new BadCredentialsException("User/password tidak valid");
            }

            UserInfoDto user = userList.get(0);

            return new UsernamePasswordAuthenticationToken(
                user.getUserId(), null, List.of(new SimpleGrantedAuthority("USER"))
            );

        } catch (Exception e) {
            throw new AuthenticationServiceException("Error autentikasi: " + e.getMessage(), e);
        }
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
