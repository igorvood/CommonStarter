package ru.vood.commonstarter.autoconfigure.configProp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("ru.vood.database")
public class InitialiseDataBaseProperty {

    boolean initialise;

}
