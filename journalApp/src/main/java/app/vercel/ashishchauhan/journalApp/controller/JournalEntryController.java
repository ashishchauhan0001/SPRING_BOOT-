//package app.vercel.ashishchauhan.journalApp.controller;
//
//import app.vercel.ashishchauhan.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//// Use PostMan for Testing the APIs
//
//@RestController
//@RequestMapping("/_journal") // this is the endpoint of the API for this whole class and on the basis of post and get It will decide what to do
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> journalEntries=new HashMap<>(); // during InMemory Working
//
//
//    // public bnane zrori hai taki bahar se API endpoint tk pauch ske
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    // we are making an instance of the JournalEntry class type from the API request of the user.
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry ){
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//
//    // for getting a specific Id ka data from the DB
//    @GetMapping("/id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//
//    // for deleting the data by ID
//    @DeleteMapping("/id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable Long myId){
//        journalEntries.remove(myId);
//        return true;
//    }
//
//    // for updating the journal Data by ID
//    @PutMapping("/id/{myId}")
//    public boolean updateJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry myEntry){
//        journalEntries.put(myId,myEntry);
//        return true;
//    }
//
//
//
//}
