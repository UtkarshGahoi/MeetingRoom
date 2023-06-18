package org.example;

import java.util.List;

public class Meeting {
    int id;
    int startTime;
    int endTime;
    List<String> emailList;

    public Meeting(List<String> emailList, int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.emailList = emailList;
    }
}
