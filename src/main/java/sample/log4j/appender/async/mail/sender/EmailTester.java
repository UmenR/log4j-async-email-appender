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
