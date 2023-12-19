package SocialMediaService;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Social.media.Entity.Post;

import com.example.Social.media.Repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepo;

    public Post submitPostToDB(Post postData){

        postData.setPostID(new PostPK(UUID.randomUUID()));
        postData.setLikes(0);
        postData.setDataTime(Instant.now());

        return postRepo.save(postData);
    }

    public List<Post> retrievePostFromDB(){
        return postRepo.findAll();
    }

    public List<Post> deletePostFromDB(PostPK postID){
        postRepo.deleteById(postID);
        List<Post> result = retrievePostFromDB();
        return result;

    }

}
