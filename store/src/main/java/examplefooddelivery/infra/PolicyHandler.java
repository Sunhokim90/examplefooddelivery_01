package examplefooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import examplefooddelivery.config.kafka.KafkaProcessor;
import examplefooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OwnerRepository ownerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_Payment(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println("\n\n##### listener Payment : " + ordered + "\n\n");

        // Sample Logic //
        Owner.payment(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordertaked'"
    )
    public void wheneverOrdertaked_CookingStart(
        @Payload Ordertaked ordertaked
    ) {
        Ordertaked event = ordertaked;
        System.out.println(
            "\n\n##### listener CookingStart : " + ordertaked + "\n\n"
        );

        // Sample Logic //
        Owner.cookingStart(event);
    }
}
