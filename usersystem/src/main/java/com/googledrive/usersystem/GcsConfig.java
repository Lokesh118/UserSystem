package com.googledrive.usersystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GcsConfig {
    // private ResourceLoader resourceLoader;

    // public GcsConfig(ResourceLoader resourceLoader){
    //     this.resourceLoader = resourceLoader;
    // }
    // @Bean
    // public JdbcTemplate jdbcTemplate() throws IOException{
    //     InputStream inputStream = resourceLoader.getResource("classpath:gcs_key.json").getInputStream();
    //     GoogleCredentials credentials = ServiceAccountCredentials.fromStream(inputStream);
    //     String jdbcUrl = String.format("jdbc:mysql:///%s?cloudSqlInstance=%s","User","drive-spring-180102045:asia-south1:sql-data-instance");
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //     dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    //     dataSource.setUrl(jdbcUrl);
    //     dataSource.setUsername("root");
    //     dataSource.setPassword("drive12@");
    //     return new JdbcTemplate(dataSource);
    // }
    
}
