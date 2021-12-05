package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Updates: Text oder bilder können geliked werden
public abstract class Pupdate {
    private int id;
    private int likecount;
    private List<String> comments = new ArrayList<String>();
    private Date date;
}
