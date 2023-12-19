package SocialMediaController;

import com.example.Social.media.Comment;
import com.example.Social.media.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/commentService")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/save")
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComments/{postID}")
    public List<Comment> getAllComments(@PathVariable("postID") UUID postID){
        return commentService.getAllComments(postID);
    }

    @DeleteMapping("/delete/{commentID}")
    public boolean deleteCommentByID(@PathVariable UUID commentID){
        Object CommentId = null;
        Comment id = new Comment(CommentId);
        return commentService.deleteComment(id);
    }
}