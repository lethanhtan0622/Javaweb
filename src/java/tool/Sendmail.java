/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SinoMax
 */
public class Sendmail {
    public static boolean sendMail(String to, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               // return new PasswordAuthentication("sinomax16.02@gmail.com", "Nhox19101995");
               return new PasswordAuthentication("lethanhtan2704@gmail.com", "huynhkimphuong");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            //message.setFrom(new InternetAddress("sinomax16.02@gmail.com"));
             message.setFrom(new InternetAddress("thanhtan21tn@yahoo.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }    
    public static void main(String[] args) {
        //System.out.println(sendMail(("sinomax16.02@gmail.com"), "Website Java Servlet", "Hello!"));
         System.out.println(sendMail(("thanhtan21tn@yahoo.com"), "Website Java Servlet", "Hello!"));
    }
}
