//package study.rj.rest.webservices.restfulwebservices.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity
////                .csrf().disable()
////                .headers().frameOptions().disable()
////                .and()
////                .authorizeRequests()
////                .antMatchers("/h2-console/**").permitAll()
////                .and()
////                .httpBasic();
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/console/**").permitAll();
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//    }
//
//}
