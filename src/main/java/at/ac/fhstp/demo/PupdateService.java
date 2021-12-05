package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PupdateService {

    private final PupdateRepository pupdateRepository;

    public PupdateService(PupdateRepository pupdateRepository) {
        this.pupdateRepository = pupdateRepository;

    }

    public List<PupdateEntity> fetchPupdates() {
        List<PupdateEntity> pupdates = new ArrayList<>();

        Iterable<PupdateEntity> all = pupdateRepository.findAll();
        all.forEach(pupdates::add);

        return pupdates;
    }

    public void savePupdates(List<PupdateEntity> pupdates) {
        pupdateRepository.saveAll(pupdates);
    }

    public void postPupdate(PupdateEntity pupdate) {
        pupdateRepository.save(pupdate);
    }

    public int likePupdate(int pupdateID, int userID) {
        Optional<PupdateEntity> pupdate = pupdateRepository.findById(pupdateID);
        if (pupdate.isEmpty())
            return -1;

        // Todo: Merken, dass der User nicht 2x Liken darf

        pupdateRepository.save(pupdate.get().like());
        return pupdate.get().getLikecount();
    }

}
