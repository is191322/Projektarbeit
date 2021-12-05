package at.ac.fhstp.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "pupdates")
@Entity
public class PupdateEntity {

    @Id
    @GeneratedValue
    private int id;
    private int OriginPupdateID;
    private int OriginUserID;
    private int UserID;
    private Date date;
    private int likecount;

    public PupdateEntity(int id, int OriginPupdateID, int OriginUserID, int UserID, Date date, int likecount) {
        this.id = id;
        this.OriginPupdateID = OriginPupdateID;
        this.OriginUserID = OriginUserID;
        this.UserID = UserID;
        this.date = date;
        this.likecount = likecount;
    }

    public PupdateEntity() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOriginPupdateID() {
        return this.OriginPupdateID;
    }

    public void setOriginPupdateID(int OriginPupdateID) {
        this.OriginPupdateID = OriginPupdateID;
    }

    public int getOriginUserID() {
        return this.OriginUserID;
    }

    public void setOriginUserID(int OriginUserID) {
        this.OriginUserID = OriginUserID;
    }

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikecount() {
        return this.likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

}
