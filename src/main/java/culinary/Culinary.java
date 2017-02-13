package culinary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Created by olya on 10.02.2017.
 */

@Configuration
@SpringBootApplication
@EnableSpringDataWebSupport
@EnableMongoAuditing
public class Culinary extends SpringBootServletInitializer {

    public static void main(final String[] args){

        SpringApplication.run(Culinary.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Culinary.class);
    }


}
