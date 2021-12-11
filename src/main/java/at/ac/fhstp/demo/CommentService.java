package at.ac.fhstp.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//Singleton nicht notwendig: By default Service annotation creates a singleton scoped bean
@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PupdateRepository pupdateRepository;

    // Kommentiert einen Post
    public void comment(int snifferID, int pupdateID, String comment) {
        if (!pupdateRepository.existsById(pupdateID))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "P mit ID " + pupdateID + " existiert nicht!");
        commentRepository.save(new CommentEntity(0, pupdateID, snifferID, new Date(), comment));
    }

    public List<CommentEntity> fetchComments(int pupdateID) {
        return commentRepository.findCommentsToPupdate(pupdateID);
    }

    public boolean existsByID(int id) {
        return commentRepository.existsById(id);
    }

}
