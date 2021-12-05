package at.ac.fhstp.demo;

import java.util.List;

//Teilnehmer im Netzwerk = Besitzer
public class Sniffer {
    private int id;
    private String name;
    private List<Update> personalupdates;
    private List<Update> sharedupdates;
    private List<Sniffer> followedpeople;
}
