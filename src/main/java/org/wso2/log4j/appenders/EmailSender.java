package org.wso2.log4j.appenders;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender implements Runnable  {
    private String subject;
    private String smtpHost;
    private String smtpUsername;
    private String smtpPassword;
    private String message;
    private String receiver;
    private String smtpPort;


    public EmailSender(String host, String subject, String user, String password, String message, String receiver, String port){
        this.subject=subject;
        this.smtpHost=host;
        this.smtpPassword=password;
        this.smtpUsername=user;
        this.message=message;
        this.receiver=receiver;
        this.smtpPort=port;
    }

    public void run() {
        Properties props = new Properties();
        //TODO: handle default values if not present
        props.put("mail.smtp.host",getSmtpHost());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", getSmtpPort());

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(getSmtpUsername(),getSmtpPassword());
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(getSmtpUsername()));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(getReceiver()));
            message.setSubject(getSubject());
            message.setText(getMessage());
            Transport.send(message);
            System.out.println("Notification sent successfully to " + getReceiver() + " for Error : " + getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public String getSmtpUsername() {
        return smtpUsername;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }
    public String getSubject() {
        return subject;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public String getSmtpHost() {
        return smtpHost;
    }
}
