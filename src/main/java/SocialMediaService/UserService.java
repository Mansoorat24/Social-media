package SocialMediaService;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Social.media.Entity.User;
import com.example.Social.media.Entity.User;
import com.example.Social.media.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User sumbitMetaDataOfUser(User user) {

        user.setUserID(new UserPK(UUID.randomUUID()));
        user.setActive(true);
        user.setJoininDate(Instant.now());

        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserData(User userID) {
        return userRepo.findById(userID);
    }

    public List<User> deleteUserByID(User user) {
        userRepo.deleteById(user);
        return getAllUsers();
    }

}
