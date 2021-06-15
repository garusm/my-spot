package pl.garusm.myspot.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user/signup", "/user/signin", "/").permitAll()
                .antMatchers("/spotify/signin", "/spotify/tracks/*", "/spotify/albums/*", "/spotify/addtrack",
                        "/spotify/addalbum", "/user/all").authenticated()
                .and()
                    .formLogin().loginPage("/login")
                    .successForwardUrl("/")
                    .permitAll();

    }


}
