package ru.vood.commonstarter.autoconfigure

import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import ru.vood.commonstarter.autoconfigure.configProp.InitialiseDataBaseProperty
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(InitialiseDataBaseProperty::class)
@ConditionalOnProperty("ru.vood.database.initialise")
open class OracleDataBaseInitialiseConfiguration {

    private val log = LogFactory.getLog(OracleDataBaseInitialiseConfiguration::class.java)

    @Autowired
    lateinit var initialiseDataBaseProperty: InitialiseDataBaseProperty

    @Bean
    @Autowired
/*
    @ConditionalOnBean(value = [JdbcTemplate::class])
    @ConditionalOnMissingBean
*/
    //@ConditionalOnProperty("ru.vood.commonStarter.db.initialiseDB")
    open fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {

        log.debug("!!!!!!!!!!!!!!!!!!!!! $initialiseDataBaseProperty")
        println("!!!!!!!!!!!!!!!!!!!!! $initialiseDataBaseProperty")
        return JdbcTemplate(dataSource)
    }

    @Bean
    //@ConditionalOnProperty("ru.vood.commonStarter.db.initialiseDB.")
//    @ConditionalOnMissingBean
    open fun dataSource(): DataSource {
        if (initialiseDataBaseProperty.url == null) throw NullPointerException("Enable to load context property ru.vood.commonStarter.db.initialiseDB.url is empty")
        if (initialiseDataBaseProperty.username == null) throw NullPointerException("Enable to load context property ru.vood.commonStarter.db.initialiseDB.username is empty")
        if (initialiseDataBaseProperty.password == null) throw NullPointerException("Enable to load context property ru.vood.commonStarter.db.initialiseDB.password is empty")
        if (initialiseDataBaseProperty.driverClassName == null) throw NullPointerException("Enable to load context property ru.vood.commonStarter.db.initialiseDB.driverClassName is empty")
        val oracleDataSource = DriverManagerDataSource(
                initialiseDataBaseProperty.url
                , initialiseDataBaseProperty.username
                , initialiseDataBaseProperty.password)
        oracleDataSource.setDriverClassName(initialiseDataBaseProperty.driverClassName)
        return oracleDataSource
    }
/*

    @Bean
    open fun liq(): LiquibaseAutoConfiguration{
        return LiquibaseAutoConfiguration()
    }
*/
}