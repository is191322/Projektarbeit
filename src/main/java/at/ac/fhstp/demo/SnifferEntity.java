package at.ac.fhstp.demo;

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

}
