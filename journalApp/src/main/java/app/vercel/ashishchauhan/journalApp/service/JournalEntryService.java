package app.vercel.ashishchauhan.journalApp.service;

// All Business Logic for the Database Operations

// Controller --> Services --> Repository

import app.vercel.ashishchauhan.journalApp.entity.JournalEntry;
import app.vercel.ashishchauhan.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

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

    public boolean deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
        return true;
    }
}
