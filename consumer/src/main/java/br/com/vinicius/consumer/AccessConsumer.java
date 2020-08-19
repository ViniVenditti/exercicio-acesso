package br.com.vinicius.consumer;

import br.com.vinicius.access.model.AccessModelLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AccessConsumer {

    @KafkaListener(topics = "spec4-vinicius-fermino-2", groupId = "vinifox")
    public void receber(@Payload AccessModelLog model) {
        try{
            FileWriter fileWriter = new FileWriter("logAccess.csv", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            StringBuilder sb = new StringBuilder();
            sb.append("Recebi o cliente ");
            sb.append(model.getClientId());
            sb.append(" na porta ");
            sb.append(model.getDoorId());
            sb.append(" e o seu acesso é ");
            sb.append(model.isAccess());
            sb.append('\n');

            printWriter.write(sb.toString());
            printWriter.close();
            System.out.println("Salvo");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
