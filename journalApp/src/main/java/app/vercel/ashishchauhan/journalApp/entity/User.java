package app.vercel.ashishchauhan.journalApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// this is our typical POJO class (Plain Old Java Object)
@Document(collection =  "users")  // this helps to tell the SB that ke ye ek Mongo ke mapped entity h
@Data
public class User {

    @Id // for making it unique
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull // this will ensure that it cannot have Null if it takes then it will throw the error.
    private String userName;
    @NonNull
    private String password;

    @DBRef // it creates the reference of the other DB collection to this DB
    private List<JournalEntry> journalEntries=new ArrayList<>();  // it will work as like the foreign key

    private List<String> roles;



}