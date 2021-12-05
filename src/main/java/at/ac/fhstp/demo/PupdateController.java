package at.ac.fhstp.demo;

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

    @GetMapping("/getPupdates1")
    public List<PupdateEntity> getPupdates1(@RequestParam(value = "username", defaultValue = "") String name) {

        // return repository.getTimeline(sniffer);
        return null;
    }

}
