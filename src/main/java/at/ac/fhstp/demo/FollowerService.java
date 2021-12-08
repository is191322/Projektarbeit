package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;
    @Autowired
    private SnifferRepository snifferRepository;

    public List<FollowerEntity> fetchFollowers() {
        return followerRepository.findAll();
    }

    public void savefollowers(List<FollowerEntity> followers) {
        followerRepository.saveAll(followers);
    }

    public void postfollower(FollowerEntity follower) {
        followerRepository.save(follower);
    }

    public List<FollowerEntity> getFollowers(int snifferID) {
        if (!(snifferRepository.existsById(snifferID))) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "SnifferID wurde konnte nicht gefunden werden!");
        }
        return followerRepository.findFollowerstoSniffer(snifferID);
    }

    public void saveFollower(FollowerEntity follower) {
        followerRepository.save(follower);
    }

    public boolean existsByID(int id) {
        return followerRepository.existsById(id);
    }
}
