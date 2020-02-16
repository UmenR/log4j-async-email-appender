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

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailAppender extends AppenderSkeleton {
    private String subject;
    private String smtpHost;
    private String smtpUsername;
    private String smtpPassword;
    private String receiver;
    private String smtpPort;

    private static ExecutorService threadPool = null;

    static {
        threadPool = Executors.newFixedThreadPool(5);
    }
    @Override
    protected void append(LoggingEvent event) {
        EmailSender emailNotification = new EmailSender(getSmtpHost(),getSubject(),getSmtpUsername(),getSmtpPassword(),event.getMessage().toString(),getReceiver(),getSmtpPort());
        threadPool.submit(emailNotification);
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }
}
