package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PupdateService {
    @Autowired
    PupdateRepository pupdateRepository;

    public List<PupdateEntity> fetchPupdates() {
        return pupdateRepository.findAll();
    }

    public List<PupdateEntity> fetchTimeline(int SnifferID) {

        // Step1 Hole alle eigenen Pupdates
        // Step2 Hole alle Pupdates von Followern
        // step3 Sortieren nach Datum
        return new ArrayList<PupdateEntity>();

    }

    public void savePupdate(PupdateEntity pupdate) {
        pupdateRepository.save(pupdate);
    }

    public int likePupdate(int pupdateID, int userID) {
        Optional<PupdateEntity> pupdate = pupdateRepository.findById(pupdateID);
        if (pupdate.isEmpty())
            return -1;

        PupdateEntity p = pupdate.get();
        p.setLikecount(p.getLikecount() + 1);
        pupdateRepository.save(pupdate.get());
        return p.getLikecount();
    }
    public PupdateEntity getPupdatebyID(int id){
        return pupdateRepository.findById(id).get();
    }
    public boolean existsByID(int id) {
        return pupdateRepository.existsById(id);
    }

}
