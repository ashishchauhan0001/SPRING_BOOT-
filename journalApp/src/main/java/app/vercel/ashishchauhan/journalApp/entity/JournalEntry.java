package app.vercel.ashishchauhan.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

// this is our typical POJO class (Plain Old Java Object)
@Document(collection =  "journal_entries")  // this helps to tell the SB that ke ye ek Mongo ke mapped entity h
public class JournalEntry {

    @Id   // making it primary key
    private ObjectId id; // it will be taken auto. by the mongoDB.


    private String title;
    private String content;
    private LocalDateTime date;



    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
}
