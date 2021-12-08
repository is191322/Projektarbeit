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

    public void init() {

    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
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

        pupdateService.savePupdate(
                new PupdateEntity(0, 0, 0, 1, new Date(), 5, "Junu, mein Hund frisst die Nachbarskatze", "", 0, 0));
    }

}
