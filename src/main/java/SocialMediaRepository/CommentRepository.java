package SocialMediaRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Social.media.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Comment>{

    @SuppressWarnings("unchecked")
    Object save(Comment comment);

    List<Comment> findAllByPostID(UUID postID);

}
