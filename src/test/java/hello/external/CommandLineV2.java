package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {

    /*
    Program Arguments에
    --url=devdb --username=dev_user --password=dev_pw mode=on
    추가하고 실행.
    '--' (더블 대쉬) : option arguments
    --로 하면 앞쪽이 key, 뒤쪽이 value가 된다.
    'mode=on'은 통으로 하나의 문자열. key-value 아니다.
    동일한 키로 여러값 저장할 수 있다(List).
     */
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs());
        log.info("OptionNames = {}", appArgs.getOptionNames());

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        // 같은 키로 여러개 저장할 수 있어서 반환타입 List.
        // --username=a --username=b --username=c
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");

        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);
        log.info("mode = {}", mode);
    }
}
