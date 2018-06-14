package cn.edu.hqu.javaee.chapter4_2;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class Chapter42Application{
	@Autowired
	private SessionFactory sessionFactory;
	public static final String ROOT = "D:\\upload-dir";

	public static void main(String[] args) throws IOException {
		File file = new File(ROOT);
		if (!file.exists()) {
			file.mkdir();
		}

		SpringApplication.run(Chapter42Application.class, args);
	}

	@Bean
	public SessionFactory sessionFactory(DataSource ds) throws IOException {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(ds);
		sfb.setPackagesToScan(new String[] { "cn.edu.hqu.javaee.chapter4_2.entity" });
		Properties props = new Properties();

		props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		sfb.setHibernateProperties(props);
		sfb.afterPropertiesSet();
		return sfb.getObject();

	}

	@Bean
	 public PlatformTransactionManager annotationDrivenTransactionManager() {
		    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		    transactionManager.setSessionFactory(sessionFactory);
		    return transactionManager;
	}
	
}
