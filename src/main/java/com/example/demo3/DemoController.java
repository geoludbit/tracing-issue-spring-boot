package com.example.demo3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Log logger = LogFactory.getLog(Demo3Application.class);
    @RequestMapping("/home")
    String home() {
        logger.info("home() has been called");
        return "Hello World!";
    }
}
