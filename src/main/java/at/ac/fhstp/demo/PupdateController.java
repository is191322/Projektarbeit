package at.ac.fhstp.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PupdateController {
    @Autowired
    PupdateService pupdateService;

    // Beispielaufruf: http://localhost:8080/getPupdates
    @GetMapping("/getPupdates")
    public List<PupdateEntity> getPupdates() {
        List<PupdateEntity> pupdates = pupdateService.fetchPupdates();
        return pupdates;
    }

    // Beispielaufruf: http://localhost:8080/post?pupdateString=abc&userid=3
    // Todo: String irgendwie speichern, User erweitern,...
    @GetMapping("/post")
    public String postPupdate(
            @RequestParam(value = "pupdateString", defaultValue = "") String pupdateString,
            @RequestParam(value = "userid", defaultValue = "") String UserID) {
        // int id, int OriginPupdateID, int OriginUserID, int UserID, Date date, int
        // likecount

        PupdateEntity pupdate = new PupdateEntity()

                .setDate(new Date())
                .setText(pupdateString)
                .setUserID(Integer.parseInt(UserID));

        pupdateService.savePupdate(pupdate);
        return pupdateString;
    }

    // Todo: Ändern auf Postmapping nach tests
    // http://localhost:8080/postPicture/?pupdateString=Schau,%20mein%20Hund%20frisst%20die%20Nachbarskatze&userid=5&picturename=cool.jpg&picturesizex=800&picturesizey=600
    @GetMapping("/postPicture")
    public String postPicture(
            @RequestParam(value = "pupdateString", required = true, defaultValue = "") String pupdateString,
            @RequestParam(value = "userid", required = true, defaultValue = "") Integer UserID,
            @RequestParam(value = "picturename", required = true, defaultValue = "") String picturename,
            @RequestParam(value = "picturesizex", required = true, defaultValue = "") Integer picturesizex,
            @RequestParam(value = "picturesizey", required = true, defaultValue = "") Integer picturesizey) {
        // int id, int OriginPupdateID, int OriginUserID, int UserID, Date date, int
        // likecount
        // Todo: String irgendwie speichern, User erweitern,...
        try {

            PupdateEntity pupdate = new PupdateEntity()

                    .setDate(new Date())
                    .setText(pupdateString)
                    .setUserID(UserID)
                    .setPictureName(picturename)
                    .setPictureSizeX(picturesizex)
                    .setPictureSizeY(picturesizey);

            pupdateService.savePupdate(pupdate);
            return pupdateString;
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    // Beispielaufruf: http://localhost:8080/like/?pupdateID=1&userid=3
    @GetMapping("/like")
    public int like(
            @RequestParam(value = "pupdateID", defaultValue = "") String pupdateID,
            @RequestParam(value = "userid", defaultValue = "") String userid) {
        // int id, int OriginPupdateID, int OriginUserID, int UserID, Date date, int
        // likecount
        // Todo: String irgendwie speichern, User erweitern,...

        return pupdateService.likePupdate(Integer.parseInt(pupdateID), Integer.parseInt(userid));
    }

}
