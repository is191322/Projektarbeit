package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Verwaltet alle Pupdates
//Singelton
public interface PupdateRepository extends JpaRepository<PupdateEntity, Integer> {
    List<PupdateEntity> findPupdatesbySniffer(int snifferID);
    // private List<Pupdate> pupdates;

    // public void AddPupdate(PupdateEntity pupdate);
    // Postet ein neues Pupdate

    // public List<PupdateEntity> getTimeline(Sniffer sniffer);
    // Holt alle Pupdates zum Sniffer
    // Holt alle Sniffer denen der übergebene Sniffer folgt und dann auch deren
    // Pupdates
    // return null;
    //

}