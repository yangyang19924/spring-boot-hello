package springboot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.AuthorSettings;

/**
 * Created by yangyang on 2018/8/6.
 */
@SpringBootApplication
@RestController
@ComponentScan("springboot.dto")
public class Application {

    @Autowired
    private AuthorSettings authorSettings;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    String home(){
        logger.info("test logger");
        return "author name is "+authorSettings.getName() + " author age is " + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
        //SpringApplication.run(Application.class,args);
    }
}
