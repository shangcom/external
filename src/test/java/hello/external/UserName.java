package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * USERNAME 환경 변수는 운영체제가 자동으로 설정하는 값으로, 현재 로그인한 사용자의 이름이 들어갑니다.
 * Environment 객체는 설정 파일뿐만 아니라 시스템 환경 변수도 조회할 수 있기 때문에,
 * 별도로 env_username을 정의하지 않았더라도 시스템의 USERNAME 값을 가져오게 됩니다.
 */
@Slf4j
@SpringBootTest
public class UserName {

    @Autowired
    private Environment env;

    @EventListener(ApplicationReadyEvent.class)
    public void checkSystemUsername() {
        String systemUsername = env.getProperty("user.name");
        System.out.println("System user.name: " + systemUsername);
        System.out.println("env_username: " + env.getProperty("env_username"));
    }

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {} = {}", key, System.getenv(key));
        }
    }
}
