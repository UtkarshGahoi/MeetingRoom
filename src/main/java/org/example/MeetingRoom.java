package org.example;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    int id;
    List<Meeting> meetings;

    public MeetingRoom(int id) {
        this.id = id;
        meetings = new ArrayList<>();
    }

    public boolean isAvailable(int startTime, int endTime) {
        for(Meeting meeting : meetings) {
            if(startTime >= meeting.startTime && startTime <= meeting.endTime ||
                    endTime >= meeting.startTime && endTime <= meeting.endTime) return false;
        }
        return true;
    }

    public Meeting bookMeeting(int id, List<String> emailList, int startTime, int endTime) {
        Meeting meeting = new Meeting(emailList, id, startTime, endTime);
        meetings.add(meeting);
        return meeting;
    }
}
