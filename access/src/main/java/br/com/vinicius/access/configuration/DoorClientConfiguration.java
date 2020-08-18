package br.com.vinicius.access.configuration;

import br.com.vinicius.access.decoder.DoorClientDecoder;
import br.com.vinicius.access.fallback.DoorClientFallback;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class DoorClientConfiguration {

    @Bean
    public ErrorDecoder getDoorClientDecoder(){
        return new DoorClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new DoorClientFallback(), RetryableException.class)
                .build();
        return Resilience4jFeign.builder(decorators);
    }
}
