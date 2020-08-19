package br.com.vinicius.access.service;

import br.com.vinicius.access.model.AccessModelLog;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccessProducer {

    private KafkaTemplate<String, AccessModelLog> producer;

    public AccessProducer(KafkaTemplate<String, AccessModelLog> producer) {
        this.producer = producer;
    }

    public void sendToKafka(AccessModelLog model) {
        System.out.println("Enviei ao kafka " + model);
        producer.send("spec4-vinicius-fermino-2", model);
    }

}
