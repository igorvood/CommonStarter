package ru.vood.commonstarter.environmentPostProcessors

import org.apache.commons.logging.LogFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter
import org.springframework.boot.env.EnvironmentPostProcessor
import org.springframework.core.env.ConfigurableEnvironment

class DeveloperProfilerResolverEnvironmentPostProcessor : EnvironmentPostProcessor {

    private val log = LogFactory.getLog(LoggingFailureAnalysisReporter::class.java)

    override fun postProcessEnvironment(environment: ConfigurableEnvironment?, application: SpringApplication?) {
        if (environment != null && environment.activeProfiles.isEmpty()) {
            val get = System.getenv()["OS"]
            var windows: String = "Windows"
            if (get != null && get.contains(windows)) {
                var s: String = "DEV"
                log.debug("NO ACTIVE PROFILE!!! Operation system is $windows, then active profile is $s")
                environment.addActiveProfile(s)
            }
        }
    }

}