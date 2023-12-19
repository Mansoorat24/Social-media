package SocialMediaService;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.Social.media.Entity.Comment;
import com.example.Social.media.Repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepo;

    public Comment saveComment(@RequestBody Comment comment) {

        comment.setComment(new Comment(UUID.randomUUID()));
        comment.setTimestamp(Instant.now());

        return commentRepo.save(comment);
    }

    public List<Comment> getAllComments(UUID postID){
        return commentRepo.findAllByPostID(postID);
    }

    public boolean deleteComment(CommentPK commentPK){
        commentRepo.deleteById(commentPK);
        return true;
    }
}
