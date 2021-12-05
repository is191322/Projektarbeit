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
    private String Text; // Text im Pupdate

    private String PictureName;
    private int PictureSizeX;
    private int PictureSizeY;

    public PupdateEntity(int id, int OriginPupdateID, int OriginUserID, int UserID, Date date, int likecount,
            String Text, String PictureName, int PictureSizeX, int PictureSizeY) {
        this.id = id;
        this.OriginPupdateID = OriginPupdateID;
        this.OriginUserID = OriginUserID;
        this.UserID = UserID;
        this.date = date;
        this.likecount = likecount;
        this.Text = Text;
        this.PictureName = PictureName;
        this.PictureSizeX = PictureSizeX;
        this.PictureSizeY = PictureSizeY;
    }

    public PupdateEntity() {

    }

    public int getId() {
        return this.id;
    }

    public PupdateEntity setId(int id) {
        this.id = id;
        return this;
    }

    public int getOriginPupdateID() {
        return this.OriginPupdateID;
    }

    public PupdateEntity setOriginPupdateID(int OriginPupdateID) {
        this.OriginPupdateID = OriginPupdateID;
        return this;
    }

    public int getOriginUserID() {
        return this.OriginUserID;
    }

    public PupdateEntity setOriginUserID(int OriginUserID) {
        this.OriginUserID = OriginUserID;
        return this;
    }

    public int getUserID() {
        return this.UserID;
    }

    public PupdateEntity setUserID(int UserID) {
        this.UserID = UserID;
        return this;
    }

    public Date getDate() {
        return this.date;
    }

    public PupdateEntity setDate(Date date) {
        this.date = date;
        return this;
    }

    public int getLikecount() {
        return this.likecount;
    }

    public PupdateEntity setLikecount(int likecount) {
        this.likecount = likecount;
        return this;
    }

    public String getText() {
        return this.Text;
    }

    public PupdateEntity setText(String Text) {
        this.Text = Text;
        return this;
    }

    public String getPictureName() {
        return this.PictureName;
    }

    public PupdateEntity setPictureName(String PictureName) {
        this.PictureName = PictureName;
        return this;

    }

    public int getPictureSizeX() {
        return this.PictureSizeX;
    }

    public PupdateEntity setPictureSizeX(int PictureSizeX) {
        this.PictureSizeX = PictureSizeX;
        return this;

    }

    public int getPictureSizeY() {
        return this.PictureSizeY;
    }

    public PupdateEntity setPictureSizeY(int PictureSizeY) {
        this.PictureSizeY = PictureSizeY;
        return this;

    }

    public PupdateEntity like() {
        this.likecount += 1;
        return this;
    }

}
