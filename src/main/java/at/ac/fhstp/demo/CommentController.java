package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@ResponseBody
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PupdateService pupdateService;

    // Beispielaufruf: http://localhost:8080/getComments?pupdateID=1
    @GetMapping("/getComments")
    public List<CommentEntity> getComments(@RequestParam(value = "pupdateID", defaultValue = "") Integer pupdateID) {

        if (!(pupdateService.existsByID(pupdateID))) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "PupdateID wurde konnte nicht gefunden werden!");
        }
        List<CommentEntity> comments = commentService.fetchComments(pupdateID);
        return comments;
    }

    // Beispielaufruf:
    // http://localhost:8080/comment?pupdateID=1&snifferID=1&commentString=test123
    // Todo: String irgendwie speichern, User erweitern,...
    @GetMapping("/comment")
    public String CommentByGetMapping(
            @RequestParam(value = "pupdateID", required = true, defaultValue = "0") Integer pupdateID,
            @RequestParam(value = "snifferID", required = true, defaultValue = "0") Integer snifferID,
            @RequestParam(value = "commentString", defaultValue = "") String commentString) {

        commentService.comment(snifferID, pupdateID, commentString);
        return commentString;
    }

    // Beispiel mit Postmapping
    // Request Body:
    // {"id":14,"pupdateID":7,"snifferID":1,"date":"2021-12-11T16:13:43.082+00:00","comment":"test123"}
    // Type Raw/JSON
    @PostMapping("/commentbyPostMapping")
    public CommentEntity CommentByPostMapping(@RequestBody CommentEntity comment) {

        commentService.comment(comment.getsnifferID(), comment.getPupdateID(),
                comment.getComment());
        return comment;
    }

}
