package data.connection;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbInitService {
    public void dbInit() {
        try (InputStream inputStream = DbInitService.class.getClassLoader().getResourceAsStream("hibernate.properties")) {
            Properties property = new Properties();
            property.load(inputStream);

            Flyway flyway = Flyway
                    .configure()
                    .dataSource(property.getProperty("hibernate.connection.url"),
                            property.getProperty("hibernate.connection.username"),
                            property.getProperty("hibernate.connection.password"))
                    .load();
            flyway.migrate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
