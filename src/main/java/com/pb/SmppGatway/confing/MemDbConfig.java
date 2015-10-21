package com.pb.SmppGatway.confing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Boris on 9/18/2015.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.pb.SmppGatway.dao.mem",
        entityManagerFactoryRef = "memEntityManager",
        transactionManagerRef = "memTransactionManager"
)
public class MemDbConfig {
    private static final Logger log = LoggerFactory.getLogger(MemDbConfig.class);

    @Autowired
    private Environment environment;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean memEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(memDataSource());
        em.setPackagesToScan(new String[] {"com.pb.SmppGatway.dao.mem"});
        em.setPersistenceUnitName("mem-PU");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto",true);
        props.put("hibernate.dialect", "H2");
        em.setJpaPropertyMap(props);


        return em;
    }

    @Primary
    @Bean
    public DataSource memDataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("mem-db-create.sql")
                .addScript("mem-db-init.sql")
                .build();
        return database;
    }


    @Primary
    @Bean
    public PlatformTransactionManager memTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(memEntityManager().getObject());
        return transactionManager;
    }
}
