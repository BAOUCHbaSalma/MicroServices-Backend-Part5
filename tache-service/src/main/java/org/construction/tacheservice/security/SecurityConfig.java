package org.construction.tacheservice.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("filtercjain///////////");

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                                expressionInterceptUrlRegistry

                                        .requestMatchers("/login").permitAll()
//                                .requestMatchers("/failure").hasAnyRole("USER","ADMIN")
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .requestMatchers("/user/**").hasRole("USER")
//                                .requestMatchers("/technician/**").hasRole("TECHNICIAN")
//                                .requestMatchers("/findtickets/**").hasAnyRole("USER","ADMIN")
                                        .anyRequest().authenticated()

                )
                .formLogin(formLogin ->formLogin.disable());
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
