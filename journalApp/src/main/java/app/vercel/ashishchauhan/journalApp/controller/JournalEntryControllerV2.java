package app.vercel.ashishchauhan.journalApp.controller;

import app.vercel.ashishchauhan.journalApp.entity.JournalEntry;
import app.vercel.ashishchauhan.journalApp.entity.User;
import app.vercel.ashishchauhan.journalApp.service.JournalEntryService;
import app.vercel.ashishchauhan.journalApp.service.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

// Use PostMan for Testing the APIs

@RestController
@RequestMapping("/journal")
// this is the endpoint of the API for this whole class and on the basis of post and get It will decide what to do
public class JournalEntryControllerV2 {


    // spring has made an instance and we are just injecting it
    @Autowired
    private JournalEntryService journalEntryService; // it is our database file's logic export like entity

    @Autowired
    private UserService userService;

    // public bnane zrori hai taki bahar se API endpoint tk pauch ske
    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findByUserName((userName));
        List<JournalEntry> response=user.getJournalEntries(); // for this particular user we will finds its all journal entries.
        if(response!=null && !response.isEmpty()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // we are making an instance of the JournalEntry class type from the API request of the user.
    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName) {
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // pathvariable --> for getting a specific Id ka data from the DB
    // add the return type of ResponseEntity with JournalEntry
    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry=journalEntryService.getJournalById(myId); // optional bcz may be id mile ya na mile;
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK); // get() is inbuilt to check if value is present or not.
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // for deleting the data by ID
    @DeleteMapping("/id/{userName}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId,@PathVariable String userName) { // <?> wildcard pattern --> generic return type, not necessary entity ka hi ho
        journalEntryService.deleteById(myId,userName); // it will return a boolean value
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // for updating the journal Data by ID
    @PutMapping("/{userName}/id/{myId}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry,
                                                    @PathVariable String userName) {
        JournalEntry old=journalEntryService.getJournalById(myId).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().isEmpty()?newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
