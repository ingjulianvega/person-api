package com.sasori.personapi.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "person")
public class PersonParameters {

    private String success;
    private String prefix;
    private Error error;
    private String channelId;

    @Getter
    @Setter
    public static class Error {
        private String general;
    }
}
