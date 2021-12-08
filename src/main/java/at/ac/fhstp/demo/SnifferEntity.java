package at.ac.fhstp.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Teilnehmer im Netzwerk = Besitzer = User
@Table(name = "sniffers")
@Entity
public class SnifferEntity {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String name;

    // SnifferController
    // SnifferRepository
    // SharedUpdates
    // PupdateC

    // private List<Sniffer> followedpeople; // Personen, denen der User folgt
    // private List<PupdateEntity> timeline;

    public SnifferEntity(int id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public SnifferEntity() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SnifferEntity id(int id) {
        setId(id);
        return this;
    }

    public SnifferEntity username(String username) {
        setUsername(username);
        return this;
    }

    public SnifferEntity name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SnifferEntity)) {
            return false;
        }
        SnifferEntity snifferEntity = (SnifferEntity) o;
        return id == snifferEntity.id && Objects.equals(username, snifferEntity.username) && Objects.equals(name, snifferEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
