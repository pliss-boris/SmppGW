package com.pb.SmppGatway.confing;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;

/**
 * Created by Boris on 9/18/2015.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.pb.SmppGatway.dao.persist",
        entityManagerFactoryRef = "persistEntityManager",
        transactionManagerRef = "persistTransactionManager"
)
@PropertySource("classpath:app.cfg.properties")
public class PersistDbConfig {
    private static final Logger log = LoggerFactory.getLogger(PersistDbConfig.class);

    @Autowired
    private Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean persistEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(persistDataSource());
        em.setPackagesToScan(new String[] {"com.pb.SmppGatway.dao.persist"});
        em.setPersistenceUnitName("persist-PU");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto",true);
        props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        em.setJpaPropertyMap(props);
        return em;
    }


    @Bean
    public DataSource persistDataSource(){
        ComboPooledDataSource cpDataSource = new ComboPooledDataSource();
        try{
            String driver = environment.getProperty("db.driver");
            cpDataSource.setDriverClass( driver );
            cpDataSource.setJdbcUrl( environment.getProperty("db.url"));
            cpDataSource.setUser( environment.getProperty("db.usr") );
            cpDataSource.setPassword( environment.getProperty("db.pwd"));
            cpDataSource.setMinPoolSize(2);
            cpDataSource.setMaxPoolSize(15);
            cpDataSource.setAcquireIncrement(1);
            cpDataSource.setIdleConnectionTestPeriod(120);


        }catch (PropertyVetoException e){
            log.error("PropertyVetoException", e);
        }
        return cpDataSource;
    }


    @Bean
    public PlatformTransactionManager persistTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(persistEntityManager().getObject());
        return transactionManager;
    }
}
