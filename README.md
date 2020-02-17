# log4j-async-email-appender
A log4j appender to send emails asynchronously.

This email appender creates a threadpool of 5 threads using the java EventExecutorService to send emails asynchronously. 

### Instructions
* Checkout repo 
* Build project using `mvn clean install`
* Copy jar file in target folder to ***<WSO2_PRODUCT>/repository/components/lib*** directory
* Follow instructions below to add appender to log4j.properties file 

```
log4j.appender.ASYNC_EMAIL_SENDER=sample.log4j.appender.async.mail.sender.EmailAppender
log4j.appender.ASYNC_EMAIL_SENDER.layout=org.wso2.carbon.utils.logging.TenantAwarePatternLayout
log4j.appender.ASYNC_EMAIL_SENDER.layout.ConversionPattern=TID: [%T] [%S] [%d] %P%5p {%c} - %x %m {%c}%n
log4j.appender.ASYNC_EMAIL_SENDER.layout.TenantPattern=%U%@%D[%T]
log4j.appender.ASYNC_EMAIL_SENDER.smtpHost=smtp.gmail.com
log4j.appender.ASYNC_EMAIL_SENDER.smtpUsername=<sender>
log4j.appender.ASYNC_EMAIL_SENDER.smtpPassword=<password>
log4j.appender.ASYNC_EMAIL_SENDER.smtpPort=587
log4j.appender.ASYNC_EMAIL_SENDER.subject=<subject>
log4j.appender.ASYNC_EMAIL_SENDER.receiver=<receiver>
log4j.appender.ASYNC_EMAIL_SENDER.filter.f=org.apache.log4j.varia.StringMatchFilter
log4j.appender.ASYNC_EMAIL_SENDER.filter.f.StringToMatch=Error occurred while obtaining LDAP connection
log4j.appender.ASYNC_EMAIL_SENDER.filter.f.AcceptOnMatch=TRUE
log4j.appender.ASYNC_EMAIL_SENDER.filter.f2=org.apache.log4j.varia.DenyAllFilter
```
By default the email sender has "starttls.enabled" property set to true.

### ***NOTE Please Remove the EmailTester.java file when building for production environments.***
