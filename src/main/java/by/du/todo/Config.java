package by.du.todo;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Locale;
import java.util.Scanner;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class Config {

    @Value("${default-locale:ru_RU}")
    private String defaultLocale;

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @PostConstruct
    private void init() {
        Locale.setDefault(Locale.forLanguageTag(defaultLocale));
    }

    @Value("${spring.datasource.driver}")
    private String dbDriver;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPass;

    @Value("${spring.liquibase.enable}")
    private boolean isEnabled;
    @Value("${spring.liquibase.changeLog}")
    private String changeLog;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource manager = new DriverManagerDataSource();
        manager.setDriverClassName(dbDriver);
        manager.setUrl(dbUrl);
        manager.setUsername(dbUser);
        manager.setPassword(dbPass);
        return manager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public SpringLiquibase springLiquibase() {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
        liquibase.setShouldRun(isEnabled);
        liquibase.setChangeLog(changeLog);
        return liquibase;
    }
}
