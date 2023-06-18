package org.example;

import java.util.List;

public interface EmailService {
    public void sendEmail(String email, Meeting meeting);
    public void sendMultipleEmail(List<String> emailList, Meeting meeting);
}
