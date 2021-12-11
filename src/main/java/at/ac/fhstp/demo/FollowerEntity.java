package at.ac.fhstp.demo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Table(name = "Follower")
@Entity
@NamedNativeQueries(value= {
    @NamedNativeQuery(name="FollowerEntity.findFollowerstoSniffer", query ="SELECT * FROM Follower WHERE Following_SnifferID = ?1", resultClass = FollowerEntity.class)})

public class FollowerEntity {
    @Id
    @GeneratedValue
    private int id;
    private int FollowingSnifferID;
    private int FollowsSnifferID;
    private Date FollowsSince;

    public FollowerEntity() {
    }

    public FollowerEntity(int id, int FollowingSnifferID, int FollowsSnifferID, Date FollowsSince) {
        this.id = id;
        this.FollowingSnifferID = FollowingSnifferID;
        this.FollowsSnifferID = FollowsSnifferID;
        this.FollowsSince = FollowsSince;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollowingSnifferID() {
        return this.FollowingSnifferID;
    }

    public void setFollowingSnifferID(int FollowingSnifferID) {
        this.FollowingSnifferID = FollowingSnifferID;
    }

    public int getFollowsSnifferID() {
        return this.FollowsSnifferID;
    }

    public void setFollowsSnifferID(int FollowsSnifferID) {
        this.FollowsSnifferID = FollowsSnifferID;
    }

    public Date getFollowsSince() {
        return this.FollowsSince;
    }

    public void setFollowsSince(Date FollowsSince) {
        this.FollowsSince = FollowsSince;
    }

    public FollowerEntity id(int id) {
        setId(id);
        return this;
    }

    public FollowerEntity FollowingSnifferID(int FollowingSnifferID) {
        setFollowingSnifferID(FollowingSnifferID);
        return this;
    }

    public FollowerEntity FollowsSnifferID(int FollowsSnifferID) {
        setFollowsSnifferID(FollowsSnifferID);
        return this;
    }

    public FollowerEntity FollowsSince(Date FollowsSince) {
        setFollowsSince(FollowsSince);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FollowerEntity)) {
            return false;
        }
        FollowerEntity followerEntity = (FollowerEntity) o;
        return id == followerEntity.id && FollowingSnifferID == followerEntity.FollowingSnifferID
                && FollowsSnifferID == followerEntity.FollowsSnifferID
                && Objects.equals(FollowsSince, followerEntity.FollowsSince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FollowingSnifferID, FollowsSnifferID, FollowsSince);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", FollowingSnifferID='" + getFollowingSnifferID() + "'" +
                ", FollowsSnifferID='" + getFollowsSnifferID() + "'" +
                ", FollowsSince='" + getFollowsSince() + "'" +
                "}";
    }

}
