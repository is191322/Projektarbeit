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
    @Autowired
    FollowerService followerService;

    public PupdateService(final PupdateRepository pupdateRepository) {
        this.pupdateRepository = pupdateRepository;
    }

    public List<PupdateEntity> fetchPupdates() {
        return pupdateRepository.findAll();
    }

    public List<PupdateEntity> getPupdatesBySniffer(int snifferID) {
        return pupdateRepository.findPupdatesbySniffer(snifferID);
    }

    public List<PupdateEntity> fetchTimeline(int SnifferID) {

        // Step1 Hole alle eigenen Pupdates
        List<PupdateEntity> timeline = new ArrayList<>();
        timeline.addAll(getPupdatesBySniffer(SnifferID));

        // Step2 Hole alle Pupdates von Followern
        List<FollowerEntity> followers = followerService.getFollowers(SnifferID);
        for (FollowerEntity f : followers) {
            timeline.addAll(getPupdatesBySniffer(f.getFollowsSnifferID()));
        }
        // step3 Sortieren nach Datum
        timeline.sort((PupdateEntity p1, PupdateEntity p2) -> p1.getDate().compareTo(p2.getDate()));
        return timeline;

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

    public PupdateEntity getPupdatebyID(int id) {
        return pupdateRepository.findById(id).get();
    }

    public boolean existsByID(int id) {
        return pupdateRepository.existsById(id);
    }

}
