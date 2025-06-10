package com.delivernow.back1_creacion_pedidos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String dbDriver;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String dbDialect;
    private String dbShowSql;
    private String dbFormatSql;

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbDialect() {
        return dbDialect;
    }

    public void setDbDialect(String dbDialect) {
        this.dbDialect = dbDialect;
    }

    public String getDbShowSql() {
        return dbShowSql;
    }

    public void setDbShowSql(String dbShowSql) {
        this.dbShowSql = dbShowSql;
    }

    public String getDbFormatSql() {
        return dbFormatSql;
    }

    public void setDbFormatSql(String dbFormatSql) {
        this.dbFormatSql = dbFormatSql;
    }
}
