package at.ac.fhstp.demo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Table(name = "pupdates")
@Entity
// @NamedNativeQueries(value = {
// @NamedNativeQuery(name = "PupdateEntity.getTimeline", query = "SELECT * FROM
// pupdates WHERE UserID = ?1 OR ", resultClass = CommentEntity.class) })

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

    public String getText() {
        return this.Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getPictureName() {
        return this.PictureName;
    }

    public void setPictureName(String PictureName) {
        this.PictureName = PictureName;
    }

    public int getPictureSizeX() {
        return this.PictureSizeX;
    }

    public void setPictureSizeX(int PictureSizeX) {
        this.PictureSizeX = PictureSizeX;
    }

    public int getPictureSizeY() {
        return this.PictureSizeY;
    }

    public void setPictureSizeY(int PictureSizeY) {
        this.PictureSizeY = PictureSizeY;
    }

    public PupdateEntity id(int id) {
        setId(id);
        return this;
    }

    public PupdateEntity OriginPupdateID(int OriginPupdateID) {
        setOriginPupdateID(OriginPupdateID);
        return this;
    }

    public PupdateEntity OriginUserID(int OriginUserID) {
        setOriginUserID(OriginUserID);
        return this;
    }

    public PupdateEntity UserID(int UserID) {
        setUserID(UserID);
        return this;
    }

    public PupdateEntity date(Date date) {
        setDate(date);
        return this;
    }

    public PupdateEntity likecount(int likecount) {
        setLikecount(likecount);
        return this;
    }

    public PupdateEntity Text(String Text) {
        setText(Text);
        return this;
    }

    public PupdateEntity PictureName(String PictureName) {
        setPictureName(PictureName);
        return this;
    }

    public PupdateEntity PictureSizeX(int PictureSizeX) {
        setPictureSizeX(PictureSizeX);
        return this;
    }

    public PupdateEntity PictureSizeY(int PictureSizeY) {
        setPictureSizeY(PictureSizeY);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PupdateEntity)) {
            return false;
        }
        PupdateEntity pupdateEntity = (PupdateEntity) o;
        return id == pupdateEntity.id && OriginPupdateID == pupdateEntity.OriginPupdateID
                && OriginUserID == pupdateEntity.OriginUserID && UserID == pupdateEntity.UserID
                && Objects.equals(date, pupdateEntity.date) && likecount == pupdateEntity.likecount
                && Objects.equals(Text, pupdateEntity.Text) && Objects.equals(PictureName, pupdateEntity.PictureName)
                && PictureSizeX == pupdateEntity.PictureSizeX && PictureSizeY == pupdateEntity.PictureSizeY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, OriginPupdateID, OriginUserID, UserID, date, likecount, Text, PictureName, PictureSizeX,
                PictureSizeY);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", OriginPupdateID='" + getOriginPupdateID() + "'" +
                ", OriginUserID='" + getOriginUserID() + "'" +
                ", UserID='" + getUserID() + "'" +
                ", date='" + getDate() + "'" +
                ", likecount='" + getLikecount() + "'" +
                ", Text='" + getText() + "'" +
                ", PictureName='" + getPictureName() + "'" +
                ", PictureSizeX='" + getPictureSizeX() + "'" +
                ", PictureSizeY='" + getPictureSizeY() + "'" +
                "}";
    }

}
