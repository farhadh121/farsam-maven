package com.radio.svc.controllers.radio;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;



/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 3/7/15
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */


public class EmailController{
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String from, String to, String subject, String msg) {

        //creating message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        //sending message
        mailSender.send(message);
    }
}