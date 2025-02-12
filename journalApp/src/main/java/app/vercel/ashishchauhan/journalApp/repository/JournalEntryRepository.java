package app.vercel.ashishchauhan.journalApp.repository;

import app.vercel.ashishchauhan.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {  // (entity(POJO),Id ka type)
}
