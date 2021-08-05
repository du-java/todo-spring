package by.du.todo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.Scanner;

@Configuration
@PropertySource(value = "classpath:app_todo.properties")
public class Config {

    @Value("${default-locale:ru_RU}")
    private String defaultLocale;

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @PostConstruct
    private void init(){
        Locale.setDefault(Locale.forLanguageTag(defaultLocale));
    }

}
