package br.com.vinicius.access.configuration;

import br.com.vinicius.access.decoder.ClientClientDecoder;
import br.com.vinicius.access.fallback.ClientClientFallback;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class ClientClientConfiguration {

    @Bean
    public ErrorDecoder getClientClientDecoder() {
        return new ClientClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new ClientClientFallback(), RetryableException.class)
                .build();
        return Resilience4jFeign.builder(decorators);
    }

}
