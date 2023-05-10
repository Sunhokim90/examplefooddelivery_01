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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercancled'"
    )
    public void wheneverOrdercancled_Ifdontstartcook(
        @Payload Ordercancled ordercancled
    ) {
        Ordercancled event = ordercancled;
        System.out.println(
            "\n\n##### listener Ifdontstartcook : " + ordercancled + "\n\n"
        );

        // Sample Logic //
        Order.ifdontstartcook(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderdropped'"
    )
    public void wheneverOrderdropped_Statusupdate(
        @Payload Orderdropped orderdropped
    ) {
        Orderdropped event = orderdropped;
        System.out.println(
            "\n\n##### listener Statusupdate : " + orderdropped + "\n\n"
        );

        // Sample Logic //
        Order.statusupdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordertaked'"
    )
    public void wheneverOrdertaked_Statusupdate(
        @Payload Ordertaked ordertaked
    ) {
        Ordertaked event = ordertaked;
        System.out.println(
            "\n\n##### listener Statusupdate : " + ordertaked + "\n\n"
        );

        // Sample Logic //
        Order.statusupdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookCompleted'"
    )
    public void wheneverCookCompleted_Statusupdate(
        @Payload CookCompleted cookCompleted
    ) {
        CookCompleted event = cookCompleted;
        System.out.println(
            "\n\n##### listener Statusupdate : " + cookCompleted + "\n\n"
        );

        // Sample Logic //
        Order.statusupdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Riderfinded'"
    )
    public void wheneverRiderfinded_Statusupdate(
        @Payload Riderfinded riderfinded
    ) {
        Riderfinded event = riderfinded;
        System.out.println(
            "\n\n##### listener Statusupdate : " + riderfinded + "\n\n"
        );

        // Sample Logic //
        Order.statusupdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliveryfinished'"
    )
    public void wheneverDeliveryfinished_Statusupdate(
        @Payload Deliveryfinished deliveryfinished
    ) {
        Deliveryfinished event = deliveryfinished;
        System.out.println(
            "\n\n##### listener Statusupdate : " + deliveryfinished + "\n\n"
        );

        // Sample Logic //
        Order.statusupdate(event);
    }
}
