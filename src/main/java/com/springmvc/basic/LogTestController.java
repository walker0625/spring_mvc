package com.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name); // 단계 구분없이 다 찍히므로 지저분하고, 정보도 빈약, 성능도 떨어짐(수십배 이상)

        // 아래로 갈 수록 중요도가 높음
        log.trace("trace log = {}", name); // 로컬개발
        log.trace("trace log=" + name); // +를 하면 문자열 연산이 불필요하게 발생하므로 +연산 사용 X
        log.debug("debug log = {}",name); // 개발서버
        log.info("info log = {}",name); // 보통 운영서버 단계(기본값)
        log.warn("warn log = {}",name);
        log.error("error log = {}",name);

        return "ok";
    }

}
