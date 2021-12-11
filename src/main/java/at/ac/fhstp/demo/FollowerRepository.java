package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//Verwaltet alle Pupdates
//Singelton
public interface FollowerRepository extends JpaRepository<FollowerEntity, Integer> {
    List<FollowerEntity> findFollowerstoSniffer(int snifferID);
}