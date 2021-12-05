package at.ac.fhstp.demo;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Eventuell nur @Controller
public class PupdateController {

    final PupdateService pupdateService;

    public PupdateController(PupdateService pupdateService) {
        this.pupdateService = pupdateService;
    }

    @GetMapping("/getPupdates")
    public List<PupdateEntity> getPupdates() {
        List<PupdateEntity> pupdates = pupdateService.fetchPupdates();
        return pupdates;
    }

    @GetMapping("/post")
    public String postPupdate(
            @RequestParam(value = "pupdateString", defaultValue = "") String pupdateString) {
        // int id, int OriginPupdateID, int OriginUserID, int UserID, Date date, int
        // likecount
        // Todo: String irgendwie speichern, User erweitern,...

        PupdateEntity pupdate = new PupdateEntity(0, 0, 0, 0, new Date(), 0);
        pupdateService.postPupdate(pupdate);
        // return repository.getTimeline(sniffer);
        return pupdateString;
    }

}
