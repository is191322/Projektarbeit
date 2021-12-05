package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnifferController {
    final SnifferService snifferService;

    public SnifferController(SnifferService snifferService) {
        this.snifferService = snifferService;
    }

    // TODO: Für Security nicht gut, wenn einfach alle User abgefragt werden können!
    // Beispielaufruf: http://localhost:8080/getSniffers
    @GetMapping("/getSniffers")
    public List<SnifferEntity> getSniffers() {
        List<SnifferEntity> sniffers = snifferService.fetchSniffers();
        return sniffers;
    }

}
