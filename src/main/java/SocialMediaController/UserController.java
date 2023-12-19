package SocialMediaController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Social.media.Entity.User;
import com.example.Social.media.Entity.User;
import com.example.Social.media.Service.UserService;

@RestController
@RequestMapping("/api/userService")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public <User> User saveUserMetaData(@RequestBody User user) {
        return userService.sumbitMetaDataOfUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUserDetails(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUserDetails/{userID}")
    public Optional<User> getUserDetail(@PathVariable("userID") UUID userID) {
        return userService.getUserData(new UserPK(userID));
    }

    @DeleteMapping("/delete/{userID}")
    public List<User> deleteUserByID(@PathVariable("userID") UUID userID){
        return userService.deleteUserByID(new UserPK(userID));
    }

}