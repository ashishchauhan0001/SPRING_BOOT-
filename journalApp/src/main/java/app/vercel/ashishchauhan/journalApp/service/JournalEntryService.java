package app.vercel.ashishchauhan.journalApp.service;

// All Business Logic for the Database Operations

// Controller --> Services --> Repository

import app.vercel.ashishchauhan.journalApp.entity.JournalEntry;
import app.vercel.ashishchauhan.journalApp.entity.User;
import app.vercel.ashishchauhan.journalApp.repository.JournalEntryRepository;
import app.vercel.ashishchauhan.journalApp.service.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

//    @Transactional //(Atomicity and Isolation Achieve) this annotation helps us to make the operations in consistent way. also enable it in JounralApp.. file
    public void saveEntry(JournalEntry journalEntry, String userName){
        User user= userService.findByUserName(userName);
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    // overLoaded method for the saveEntry
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllData(){
        System.out.println("IN GETallDATA FUNCTION");
        return journalEntryRepository.findAll();
    }

// optional isliye bcz hobhe skta hai aur nahi bhe data for a particular Id.
    public Optional<JournalEntry> getJournalById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id, String userName){
        User user= userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user); // ultimately it will update bcz this will present in the DB for sure
        journalEntryRepository.deleteById(id);
        return true;
    }
}
