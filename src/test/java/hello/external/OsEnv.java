package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {

    /*
    시스템 환경은 읽기만 가능함.
     */
    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {} = {}", key, System.getenv());
        }
    }
}
