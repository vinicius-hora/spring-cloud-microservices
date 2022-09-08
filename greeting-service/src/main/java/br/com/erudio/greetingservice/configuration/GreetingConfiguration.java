package br.com.erudio.greetingservice.configuration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting-service")
@Getter
@Setter
public class GreetingConfiguration {

    private String  greeting;

    private String defaultValue;

    public GreetingConfiguration() {
    }
}
