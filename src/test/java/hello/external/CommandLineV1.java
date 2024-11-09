package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV1 {

    /*
    Program Argements에
    dataA dataB
    입력하고 실행.
    띄어쓰기로 구분.
    key-value 형식 아님.
     */
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);

        }
    }
}
