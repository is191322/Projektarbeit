package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Initializer {
    @Autowired
    SnifferService snifferService;

    @Autowired
    PupdateService pupdateService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        initSniffers();
        initPupdates();
    }

    private void initSniffers() {
        System.out.println("Initialisiere Sniffers");

        List<SnifferEntity> sniffers = new ArrayList<>();

        sniffers.add(new SnifferEntity(0, "is191325", "Philipp Zöchbauer"));
        sniffers.add(new SnifferEntity(0, "is191322", "Christopher Fritz"));

        sniffers.add(new SnifferEntity(0, "Fiffy1", "Fiffy"));
        sniffers.add(new SnifferEntity(0, "Balu1", "Balu"));
        sniffers.add(new SnifferEntity(0, "Hasso1", "Hasso"));
        sniffers.add(new SnifferEntity(0, "Rocky1", "Rocky"));

        snifferService.savesniffers(sniffers);

    }

    private void initPupdates() {
        System.out.println("Initialisiere Pupdates");
        pupdateService.savePupdate(new PupdateEntity(0, 0, 0, 1, new Date(), 5,
                "Junu, mein Hund frisst die Nachbarskatze", "is191325.jpg", 800, 600));
        pupdateService.savePupdate(
                new PupdateEntity(0, 0, 0, 3, new Date(), 5, "Mein Hund hat Flöhe", "Fiffy.jpg", 800, 600));
        pupdateService.savePupdate(new PupdateEntity(0, 1, 1, 2, new Date(), 5,
                "Junu, mein Hund frisst die Nachbarskatze", "is191325.jpg", 800, 600));
        pupdateService.savePupdate(new PupdateEntity(0, 0, 0, 1, new Date(), 5,
                "Die Nachbarskatze hat meinen Hund gefressen!", "is191325.jpg", 800, 600));
        pupdateService.savePupdate(new PupdateEntity(0, 0, 0, 3, new Date(), 5,
                "Waschen hilft nicht, er hat immer noch Flöhe", "cool.jpg", 800, 600));
    }

}
