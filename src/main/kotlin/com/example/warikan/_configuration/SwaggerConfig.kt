package com.example.warikan._configuration

import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.time.LocalTime

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api() = Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).directModelSubstitute(
        LocalTime::class.java,
        String::class.java
    ).apiInfo(apiInfo()).select().paths(patterns()).build()

    private fun patterns() = Predicates.or(regex("/api.*"))

    private fun apiInfo() = ApiInfoBuilder().title("割り勘").description("会話式に api を実行してみてください").build()
}