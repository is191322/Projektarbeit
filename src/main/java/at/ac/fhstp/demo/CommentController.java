package at.ac.fhstp.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PupdateRepository pupdateRepository;

    // public CommentController(CommentService commentService) {
    // this.commentService = commentService;
    // this.pupdateRepository = pupdateRepository;
    // }

    // Beispielaufruf: http://localhost:8080/getComments?pupdateID=1
    @GetMapping("/getComments")
    public List<CommentEntity> getComments(@RequestParam(value = "pupdateID", defaultValue = "") Integer pupdateID) {

        if (!(new PupdateService().existsByID(pupdateID))) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "PupdateID wurde konnte nicht gefunden werden!");
        }
        List<CommentEntity> comments = commentService.fetchComments(pupdateID);
        return comments;
    }

    // Beispielaufruf:
    // http://localhost:8080/comment?pupdateID=1&snifferID=1&commentString=test123
    // Todo: String irgendwie speichern, User erweitern,...
    @GetMapping("/comment")
    public String postComment(
            @RequestParam(value = "pupdateID", required = true, defaultValue = "0") Integer pupdateID,
            @RequestParam(value = "snifferID", required = true, defaultValue = "0") Integer snifferID,
            @RequestParam(value = "commentString", defaultValue = "") String commentString) {
        // int id, int OriginCommentID, int OriginUserID, int UserID, Date date, int
        // likecount

        CommentEntity comment = new CommentEntity()

                .date(new Date())
                .comment(commentString)
                .snifferID(snifferID)
                .pupdateID(pupdateID);

        commentService.saveComment(comment);

        return commentString;
    }

}
