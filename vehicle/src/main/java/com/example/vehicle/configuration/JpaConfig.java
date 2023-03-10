//package com.example.vehicle.configuration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import jakarta.persistence.EntityManagerFactory;
// 
//@Configuration
//@EnableJpaRepositories(basePackages = {"com.example.vehicle.controller"})
//@EnableTransactionManagement
//public class JpaConfig {
//	  @Bean
//	    public LocalEntityManagerFactoryBean entityManagerFactory() {
//	        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//	        factoryBean.setPersistenceUnitName("VehiclesDB");
//	          
//	        return factoryBean;
//	    }
//	      
//	    @Bean
//	    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//	        JpaTransactionManager transactionManager = new JpaTransactionManager();
//	        transactionManager.setEntityManagerFactory(entityManagerFactory);
//	          
//	        return transactionManager;
//	    } 
//}
