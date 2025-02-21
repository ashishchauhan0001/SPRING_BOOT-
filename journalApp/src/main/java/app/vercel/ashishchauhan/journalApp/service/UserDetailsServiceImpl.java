package app.vercel.ashishchauhan.journalApp.service;


import app.vercel.ashishchauhan.journalApp.entity.User;
import app.vercel.ashishchauhan.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(user!=null){
            // we want it in String format
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0])) // we want it in String format
                    .build();
        }
        throw new UsernameNotFoundException("User Not Found with name : "+ username);
    }
}
