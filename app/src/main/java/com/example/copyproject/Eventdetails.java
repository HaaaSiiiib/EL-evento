package com.example.copyproject;

public class Eventdetails {

    public String eventname,eventdate,eventlocation,uid;
    public  Eventdetails(){

    }

    public Eventdetails(String eventname, String eventdate, String eventlocation,String uid) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.eventlocation = eventlocation;
        this.uid=uid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }
}
