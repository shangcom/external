package hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@Slf4j
@SpringBootApplication
public class JavaSystem {

    public static void print() {
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("property {} = {}", key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);
    }

}
