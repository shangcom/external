package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class CommandLineBean {

    /*
     ApplicationArguments :
     커맨드 라인 옵션 인수(--key=value 형식), 프로그램 인수(단순 문자열, 논옵션.) 보관.
     스프링이 자동으로 빈으로 등록한다. 꺼내서 사용하면 된다.
     */
    private final ApplicationArguments arguments;

    public CommandLineBean(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    @PostConstruct
    public void init() {
       log.info("source {}", List.of(arguments.getSourceArgs()));
       log.info("optionNames {}", arguments.getOptionNames());
        Set<String> optionNames = arguments.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option args {} = {}", optionName, arguments.getOptionValues(optionName));
        }
    }
}
