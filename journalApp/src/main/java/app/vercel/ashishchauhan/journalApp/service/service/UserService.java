package app.vercel.ashishchauhan.journalApp.service.service;

// All Business Logic for the Database Operations

// Controller --> Services --> Repository

import app.vercel.ashishchauhan.journalApp.entity.User;
import app.vercel.ashishchauhan.journalApp.repository.UserRepository;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


//    public void saveEntry(User user){
//        userRepository.save(user);
//    }

    public void saveEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("User"));
        userRepository.save(user);
    }

    public List<User> getAllData(){
        System.out.println("IN GETallDATA FUNCTION");
        return userRepository.findAll();
    }

// optional isliye bcz hobhe skta hai aur nahi bhe data for a particular Id.
    public Optional<User> getUserById(@NonNull ObjectId id){
        return userRepository.findById(id);
    }

    public boolean deleteById(ObjectId id){
        userRepository.deleteById(id);
        return true;
    }
    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }
}
