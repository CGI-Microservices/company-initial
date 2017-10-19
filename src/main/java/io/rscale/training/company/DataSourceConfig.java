package io.rscale.training.company;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@Profile("cf")
public class DataSourceConfig extends AbstractCloudConfig {

    private static final Logger logger = Logger.getLogger(DataSourceConfig.class);

   
    private DataSource dataSource;
    
    public DataSourceConfig() {
        logger.info(this.getClass() + " loaded");
    }
    

    @Bean
   	public DataSource dataSource() throws Exception {
        DataSource dataSource = cloud().getSingletonServiceConnector(DataSource.class, null);
        if ( !isMySQL(dataSource)) {
            logger.error("MySQL required when running cloud profile.");
            throw new UnsatisfiedDependencyException("javax.sql.DataSource", "javax.sql.DataSource", "javax.sql.DataSource", "MySQL required when running cloud profile.");
        }
        return dataSource;
   }

    	
    
    private boolean isMySQL(DataSource dataSource) {
        // implement me!
    	return false;
      }

}
