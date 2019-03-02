package ru.vood.commonstarter.autoconfigure.configProp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Getter
@Setter
@ConfigurationProperties("ru.vood.database")
public class InitialiseDataBaseProperty {

    public boolean initialise;

    public String checkLog;

    public String driverClassName;//oracle.jdbc.driver.OracleDriver

    public String password;

    public String username;

    public String url;//: jdbc:oracle:thin:@localhost:1521:vood


}
