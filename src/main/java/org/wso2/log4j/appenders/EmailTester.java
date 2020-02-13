package org.wso2.log4j.appenders;

import org.apache.log4j.Logger;

public class EmailTester {
    private static Logger log = Logger.getRootLogger();
    public static void main(String [] args){
        System.out.println("1");
        log.error("Error occurred while obtaining LDAP connection, LDAP connection circuit breaker state set to: open");
        System.out.println("2");
        System.out.println("3");
        log.error("Error occurred while obtaining LDAP connection, LDAP connection circuit breaker state set to: closed");
        System.out.println("4");
    }
}
