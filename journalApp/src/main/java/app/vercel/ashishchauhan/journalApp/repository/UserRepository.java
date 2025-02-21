package app.vercel.ashishchauhan.journalApp.repository;

import app.vercel.ashishchauhan.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {  // (entity(POJO),Id ka type)
User findByUserName( String userName);
}
