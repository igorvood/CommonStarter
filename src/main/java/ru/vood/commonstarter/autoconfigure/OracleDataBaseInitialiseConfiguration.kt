package ru.vood.commonstarter.autoconfigure

import org.apache.commons.logging.LogFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import ru.vood.commonstarter.autoconfigure.configProp.InitialiseDataBaseProperty

@Configuration
@EnableConfigurationProperties(InitialiseDataBaseProperty::class)
open class OracleDataBaseInitialiseConfiguration {

    private val log = LogFactory.getLog(OracleDataBaseInitialiseConfiguration::class.java)

    @Bean
    @ConditionalOnBean(value = [JdbcTemplate::class])
    @ConditionalOnProperty("ru.vood.commonStarter.db.initialiseDB")
    @ConditionalOnMissingBean
    open fun sdfsf(jdbcTemplate: JdbcTemplate) {
        log.debug("$jdbcTemplate")
    }

/*
    @Bean
    open fun liq(): LiquibaseAutoConfiguration{
        return LiquibaseAutoConfiguration()
    }
*/
}