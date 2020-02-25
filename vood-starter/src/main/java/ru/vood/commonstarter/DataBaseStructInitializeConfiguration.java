package ru.vood.commonstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@ConditionalOnBean(type = {"org.springframework.jdbc.core.JdbcOperations"})
//@ConditionalOnTableExists
public class DataBaseStructInitializeConfiguration {


//    @Bean
//    public SpringLiquibase springLiquibase(LiquibaseProperties properties,
//                                           DataSourceProperties dataSourceProperties,
//                                           ResourceLoader resourceLoader,
//                                           ObjectProvider<DataSource> dataSource,
//                                           @LiquibaseDataSource ObjectProvider<DataSource> liquibaseDataSource) {
//        return new SpringLiquibase();
//    }

    @Bean
    public XmlStructProcessor stringBuffer(JdbcOperations jdbcOperations)  {
        final File[] files = new File("vood-starter\\src\\main\\resources\\db").listFiles();
        Stream.of(new File("vood-starter\\src\\main\\resources\\db").listFiles())
                .sorted()

                .map(new Function<File, String>() {
                    @Override
                    public String apply(File f) {
                        try {
                            return Files.readAllLines(f.toPath()).stream().reduce((s, s1) -> s + s1).get();
                        } catch (IOException e) {
                            throw new IllegalStateException("нет такого файла"+f.getName());
                        }

                    }
                })
                .peek(f-> System.out.println(f))

                .collect(toList());

//        jdbcOperations.update("insert into jp.META_ENUM_PK_1(ID, DESCRIPTION) SELECT to_char(current_date), 1 from DUAL");
        return new XmlStructProcessor();
    }
}
