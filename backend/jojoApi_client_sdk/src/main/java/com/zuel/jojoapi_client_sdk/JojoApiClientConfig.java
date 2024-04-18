package com.zuel.jojoapi_client_sdk;

import com.zuel.jojoapi_client_sdk.client.JojoApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("jojoapi.client")
@Data
@ComponentScan
public class JojoApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public JojoApiClient jojoApiClient() {
        return new JojoApiClient(accessKey, secretKey);
    }
}
