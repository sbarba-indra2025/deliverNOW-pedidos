package com.delivernow.back1_creacion_pedidos;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;



@Configuration
@EnableConfigurationProperties(AppConfig.class)
@EnableJpaRepositories(basePackages="com.delivernow.back1_creacion_pedidos.repositories")
public class HibernateConfig {
    private final AppConfig appConfig;
    public HibernateConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource()); // Configurar el DataSource
        sessionFactory.setPackagesToScan("com.delivernow.back1_creacion_pedidos.entities"); // Reemplazar con el paquete de tus entidades
        sessionFactory.setHibernateProperties(hibernateProperties());
        // sessionFactory.afterPropertiesSet();
        return sessionFactory.getObject();
    }
    @Bean
    public org.springframework.jdbc.datasource.DriverManagerDataSource dataSource() {
        org.springframework.jdbc.datasource.DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        dataSource.setDriverClassName(appConfig.getDbDriver());
        dataSource.setUrl(appConfig.getDbUrl());
        dataSource.setUsername(appConfig.getDbUser());
        dataSource.setPassword(appConfig.getDbPassword());
        return dataSource;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", appConfig.getDbDialect());
        properties.put("hibernate.show_sql", appConfig.getDbShowSql());
        properties.put("hibernate.format_sql", appConfig.getDbFormatSql());
        return properties;
    }
}
