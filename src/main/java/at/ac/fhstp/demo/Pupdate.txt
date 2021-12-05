package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Updates: Text oder bilder können geliked werden
public abstract class Pupdate {
    private int id;
    private int OriginPupdateID;
    private int OriginUserID;
    private int UserID;
    private Date date;
    private int likecount;
    private List<String> comments = new ArrayList<String>();

}
