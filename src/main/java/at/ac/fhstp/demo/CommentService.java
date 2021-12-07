package at.ac.fhstp.demo;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//Singleton nicht notwendig: By default Service annotation creates a singleton scoped bean
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Kommentiert einen Post
    public void comment(int snifferID, int pupdateID, String comment) {

        // PostExists?
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "P mit ID " + pupdateID + " existiert nicht!");
        // UserExists?
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sniffer mit ID " +
        // snifferID + " existiert nicht!");

        // commentRepository.save(new CommentEntity(snifferID, commentID, comment));
    }

    public List<CommentEntity> fetchComments(int pupdateID) {

        return commentRepository.findCommentsToPupdate(pupdateID);
    }

    public void saveComments(List<CommentEntity> comments) {
        commentRepository.saveAll(comments);
    }

    public void saveComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    public boolean existsByID(int id) {
        return commentRepository.existsById(id);
    }

}
