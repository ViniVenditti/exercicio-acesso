package br.com.vinicius.consumer;

import br.com.vinicius.access.model.AccessModelLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AccessConsumer {

    @KafkaListener(topics = "spec4-vinicius-fermino-2", groupId = "vinifox")
    public void receber(@Payload AccessModelLog model) {
        System.out.println("Recebi o acesso no cliente " + model.getClientId() + " na porta " + model.getDoorId() + " e o acesso é " + model.isAccess());
    }

}
