package SocialMediaController;

import com.example.Social.media.Entity.Post;
import com.example.Social.media.PostService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postService")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/save")
    public Post savePost(@RequestBody Post body){
        return postService.submitPostToDB(body);
    }

    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts(){
        return postService.retrievePostFromDB();
    }

    @DeleteMapping("/delete/{postID}")
    public List<Post> deletePostByID(@PathVariable("postID") UUID postID){
        PostPK pk = new PostPK(postID);
        return postService.deletePostFromDB(pk);
    }

}
