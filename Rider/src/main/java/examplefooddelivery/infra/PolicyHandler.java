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
    RiderRepository riderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Riderfinded'"
    )
    public void wheneverRiderfinded_PickupNotify(
        @Payload Riderfinded riderfinded
    ) {
        Riderfinded event = riderfinded;
        System.out.println(
            "\n\n##### listener PickupNotify : " + riderfinded + "\n\n"
        );

        // Sample Logic //
        Rider.pickupNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookCompleted'"
    )
    public void wheneverCookCompleted_FindRider(
        @Payload CookCompleted cookCompleted
    ) {
        CookCompleted event = cookCompleted;
        System.out.println(
            "\n\n##### listener FindRider : " + cookCompleted + "\n\n"
        );

        // Sample Logic //
        Rider.findRider(event);
    }
}
