package com.googledrive.usersystem.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

// import org.springframework.core.io.ResourceLoader;

// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.auth.oauth2.ServiceAccountCredentials;
// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;

public class CloudSqlConnectionPoolFactory {
    // private static final String INSTANCE_CONNECTION_NAME = "drive-spring-180102045:asia-south1:sql-data-instance";
    // private static final String DB_USER = "root";
    // private static final String DB_PASS = "drive12@";
    // private static final String DB_NAME = "User";

    // // private ResourceLoader resourceLoader;
    // // public CloudSqlConnectionPoolFactory(ResourceLoader resourceLoader){
    // //     this.resourceLoader = resourceLoader;
    // // }
    // // public GoogleCredentials loadCredentials() throws IOException{
    // //     InputStream inputStream = resourceLoader.getResource("classpath:gcs_key.json").getInputStream();
    // //     GoogleCredentials credentials = ServiceAccountCredentials.fromStream(inputStream);
    // //     return credentials;
    // // }
    // public static DataSource createConnectionPool(){
    //     // GoogleCredentials credentials = loadCredentials();
    //     HikariConfig config = new HikariConfig();
    //     config.setJdbcUrl(String.format("jdbc:mysql:///%s",DB_NAME));
    //     config.setUsername(DB_USER);
    //     config.setPassword(DB_PASS);
    //     config.addDataSourceProperty("socketFactory","com.google.cloud.sql.mysql.SocketFactory");
    //     config.addDataSourceProperty("cloudSqlInstance",INSTANCE_CONNECTION_NAME);
    //     config.addDataSourceProperty("useSSL","FALSE");
    //     return new HikariDataSource(config);
    // }
}
