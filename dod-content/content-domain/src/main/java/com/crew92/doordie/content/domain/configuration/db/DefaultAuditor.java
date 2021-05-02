package com.crew92.doordie.content.domain.configuration.db;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class DefaultAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system|system");
    }

}