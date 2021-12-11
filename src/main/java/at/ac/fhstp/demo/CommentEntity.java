package at.ac.fhstp.demo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Table(name = "Comments")
@Entity
// Source:
// https://www.javaguides.net/2018/11/spring-data-jpa-namednativequery-namednativequeries-example.html
// @NamedNativeQuery(name = "CommentEntity.findCommentsToPupdate", query =
// "SELECT * FROM Comments WHERE pupdateID = ?1", resultClass =
// CommentEntity.class)

@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "CommentEntity.findCommentsToPupdate", query = "SELECT * FROM Comments WHERE pupdateID = ?1", resultClass = CommentEntity.class) })

public class CommentEntity {
    @Id
    @GeneratedValue
    private int id;
    private int pupdateID;
    private int snifferID;
    private Date date;
    private String comment;

    public CommentEntity() {
    }

    public CommentEntity(int id, int pupdateID, int snifferID, Date date, String comment) {
        this.id = id;
        this.pupdateID = pupdateID;
        this.snifferID = snifferID;
        this.date = date;
        this.comment = comment;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPupdateID() {
        return this.pupdateID;
    }

    public void setPupdateID(int pupdateID) {
        this.pupdateID = pupdateID;
    }

    public int getsnifferID() {
        return this.snifferID;
    }

    public void setsnifferID(int snifferID) {
        this.snifferID = snifferID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentEntity id(int id) {
        setId(id);
        return this;
    }

    public CommentEntity pupdateID(int pupdateID) {
        setPupdateID(pupdateID);
        return this;
    }

    public CommentEntity snifferID(int snifferID) {
        setsnifferID(snifferID);
        return this;
    }

    public CommentEntity date(Date date) {
        setDate(date);
        return this;
    }

    public CommentEntity comment(String comment) {
        setComment(comment);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentEntity)) {
            return false;
        }
        CommentEntity commentEntity = (CommentEntity) o;
        return id == commentEntity.id && pupdateID == commentEntity.pupdateID && snifferID == commentEntity.snifferID
                && Objects.equals(date, commentEntity.date) && Objects.equals(comment, commentEntity.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pupdateID, snifferID, date, comment);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", pupdateID='" + getPupdateID() + "'" +
                ", snifferID='" + getsnifferID() + "'" +
                ", date='" + getDate() + "'" +
                ", Comment='" + getComment() + "'" +
                "}";
    }

}
