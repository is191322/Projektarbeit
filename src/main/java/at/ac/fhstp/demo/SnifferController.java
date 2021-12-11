package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnifferController {
    @Autowired
    SnifferService snifferService;

    // TODO: Für Security nicht gut, wenn einfach alle User abgefragt werden können!
    // Beispielaufruf: http://localhost:8080/getSniffers
    @GetMapping("/getSniffers")
    public List<SnifferEntity> getSniffers() {
        List<SnifferEntity> sniffers = snifferService.fetchSniffers();
        return sniffers;
    }

    // http://localhost:8080/createSniffer?Name=Christopher Fritz&username=is191322
    @GetMapping("/createSniffer")
    public String createSniffer(
            @RequestParam(value = "Name", required = true, defaultValue = "") String name,
            @RequestParam(value = "username", required = true, defaultValue = "") String username) {
        SnifferEntity sniffer = new SnifferEntity()
                .name(name)
                .username(username);

        snifferService.postsniffer(sniffer);
        return "User: " + username + " erfolgreich angelegt";
    }

    // http://localhost:8080/getSnifferByID?ID=1
    @GetMapping("/getSnifferByID")
    public SnifferEntity getSnifferByID(
            @RequestParam(value = "ID", defaultValue = "") int snifferID) {
        SnifferEntity sniffer = snifferService.getSniffer(snifferID);
        return sniffer;
    }

}
