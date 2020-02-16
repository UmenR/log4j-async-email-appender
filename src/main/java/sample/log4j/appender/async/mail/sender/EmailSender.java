/**
 * Copyright 2020 Umendra Rajapakshe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.log4j.appender.async.mail.sender;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Message;
import javax.mail.Transport;
import java.util.Properties;

public class EmailSender implements Runnable  {
    private String subject;
    private String smtpHost;
    private String smtpUsername;
    private String smtpPassword;
    private String message;
    private String receiver;
    private String smtpPort;
    private static final Log log = LogFactory.getLog(EmailSender.class);


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
            log.info("Email Notification sent successfully to " + getReceiver());
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
