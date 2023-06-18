package org.example;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    int MAX_MEETING_ROOMS;
    List<MeetingRoom> meetingRoomList;
    int idCounter;
    List<Meeting> history;
    EmailService emailService;

    public MeetingScheduler(int n, EmailService emailService) {
        MAX_MEETING_ROOMS = n;
        this.emailService = emailService;
        meetingRoomList = new ArrayList<>();
        idCounter = 0;
        history = new ArrayList<>();
        initMeetingRooms();
    }

    private void initMeetingRooms() {
        for (int i = 0; i < MAX_MEETING_ROOMS; i++) {
            MeetingRoom room = new MeetingRoom(i);
            meetingRoomList.add(room);
        }
    }

    public synchronized Meeting bookMeeting(List<String> emailList, int startTime, int endTime) throws Exception {
        for (MeetingRoom room : meetingRoomList) {
            if (room.isAvailable(startTime, endTime)) {
                Meeting meeting = room.bookMeeting(idCounter++, emailList, startTime, endTime);
                emailService.sendMultipleEmail(emailList, meeting);
                history.add(meeting);
                return meeting;
            }
        }
        throw new Exception("Meeting Room Unavailable");
    }

    public List<Meeting> getHistoryOfMeetings(int size) {
        int historySize = history.size();
        int finalSize = size < historySize ? historySize : size;
        return new ArrayList<>(history.subList(historySize - finalSize, historySize));
    }
}
