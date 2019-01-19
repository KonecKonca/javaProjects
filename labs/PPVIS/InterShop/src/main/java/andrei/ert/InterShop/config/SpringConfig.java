package andrei.ert.InterShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"andrei.ert.InterShop.service.*", "andrei.ert.InterShop.dao"})  // Вместо методов типа @Bean юзаем компонентСкан (тупо указываем директорию, бины из которой нужно созлать)
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/shop?useSll=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123ghu475R7px6");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;
    }

}
