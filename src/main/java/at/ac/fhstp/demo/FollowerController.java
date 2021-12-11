package at.ac.fhstp.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FollowerController {
    @Autowired
    FollowerService followerService;
    //http://localhost:8080/getFollowers?snifferID=1
    @GetMapping("/getFollowers")
    public List<FollowerEntity> getFollowers(
        @RequestParam(value="snifferID",defaultValue = "") int snifferID){

            List<FollowerEntity> followers = followerService.getFollowers(snifferID);
            return followers;
        }
    // http://localhost:8080/follow?FollowingSnifferID=1&FollowsSnifferID=2
    @GetMapping("/follow")
    public String follow(
        @RequestParam(value="FollowingSnifferID",required = true, defaultValue = "0") int FollowingSnifferID,
        @RequestParam(value="FollowsSnifferID",required = true,defaultValue = "0") int FollowsSnifferID){
        
        FollowerEntity follower = new FollowerEntity()
        .FollowingSnifferID(FollowingSnifferID)
        .FollowsSnifferID(FollowsSnifferID)
        .FollowsSince(new Date());
        
        followerService.saveFollower(follower);
        return "Follower saved";
        }
    
}
