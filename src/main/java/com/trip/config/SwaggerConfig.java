package com.trip.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String REFERENCE = "Authorization";

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan("com.trip")
                .addOpenApiCustomizer(openAPIDefinition())
                .build();
    }
    private OpenApiCustomizer openAPIDefinition() {
        return openApi -> {
            openApi.info(new Info().title("여행길")
                    .version("v1")
                    .description("여행을 요율적이게")
                    .contact(new Contact().name("권동휘").email("tnqlsdld1@naver.com")));
            openApi.addSecurityItem(new SecurityRequirement().addList(REFERENCE));
            openApi.components(new Components()
                    .addSecuritySchemes(REFERENCE, new SecurityScheme()
                            .name(REFERENCE)
                            .type(SecurityScheme.Type.HTTP)
                            .in(SecurityScheme.In.HEADER)
                            .scheme("Bearer")
                            .name("Authorization Bearer도 붙이셈")));
        };
    }
}
