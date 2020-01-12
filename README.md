# log4j-async-email-appender
A log4j appender to send emails asynchronously.

This email appender creates a threadpool of 5 threads using the java EventExecutorService to send emails asynchronously. 

* Checkout repo 
* Build project using `mvn clean install`
* Copy jar file in target folder to ***<WSO2_PRODUCT>/repository/components/lib*** directory
* Follow instructions below to add appender to log4j.properties file 

```
log4j.appender.mailappender=org.wso2.log4j.appenders.emailAppender
log4j.appender.mailappender.layout=org.apache.log4j.PatternLayout
log4j.appender.mailappender.layout.ConversionPattern=%-4r [%t] %-5p %c %x - %m%n
log4j.appender.mailappender.smtpHost=<host>
log4j.appender.mailappender.smtpUsername=<email-address>
log4j.appender.mailappender.smtpPassword=<password>
log4j.appender.mailappender.subject=testsubject
log4j.appender.mailappender.receiver=<receiver_email>
log4j.appender.mailappender.smtpPort=<port>
```
* By default email sender has starttls.enabled property set to true.
