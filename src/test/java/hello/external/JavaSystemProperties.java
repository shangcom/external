package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystemProperties {

    public static void main(String[] args) {

        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("property {} = {}", key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        /*
        vm options에
        -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw
        입력하고 적용한 뒤 실행할 것.
        그렇지 않으면 아래 내용 null로 나온다.

        만약 jar로 만들어져 있다면, cmd로 실행할 때
        java -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw -jar app.jar
        이렇게 실행하면 된다.
         */

        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);

        /*
        setProperty()를 사용하면 애플리케이션 내부에서 동적으로 시스템 속성을 설정 가능함.
        env는 읽기만 가능.
         */
        System.setProperty("hello_key", "hello_value");
        String hello_Key = System.getProperty("hello_key");
        log.info("hello_key = {}", hello_Key);

    }
}
