package examplefooddelivery.infra;

import examplefooddelivery.config.kafka.KafkaProcessor;
import examplefooddelivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DeliveryStatusViewHandler {

    @Autowired
    private DeliveryStatusRepository deliveryStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view 객체 생성
            DeliveryStatus deliveryStatus = new DeliveryStatus();
            // view 객체에 이벤트의 Value 를 set 함
            deliveryStatus.setOrderId(String.valueOf(ordered.getId()));
            deliveryStatus.setStoreName(ordered.getStoreName());
            deliveryStatus.setSelectManu(ordered.getSelectManu());
            deliveryStatus.setStatus(ordered.getStatus());
            // view 레파지 토리에 save
            deliveryStatusRepository.save(deliveryStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdertaked_then_UPDATE_1(@Payload Ordertaked ordertaked) {
        try {
            if (!ordertaked.validate()) return;
            // view 객체 조회

            List<DeliveryStatus> deliveryStatusList = deliveryStatusRepository.findByStatus(
                ordertaked.getStatus()
            );
            for (DeliveryStatus deliveryStatus : deliveryStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deliveryStatus.setOrderId(ordertaked.getOrderId());
                deliveryStatus.setStatus(ordertaked.getStatus());
                // view 레파지 토리에 save
                deliveryStatusRepository.save(deliveryStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRiderfinded_then_UPDATE_2(
        @Payload Riderfinded riderfinded
    ) {
        try {
            if (!riderfinded.validate()) return;
            // view 객체 조회

            List<DeliveryStatus> deliveryStatusList = deliveryStatusRepository.findByStatus(
                riderfinded.getStatus()
            );
            for (DeliveryStatus deliveryStatus : deliveryStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deliveryStatus.setOrderId(riderfinded.getOrderId());
                deliveryStatus.setStatus(riderfinded.getStatus());
                // view 레파지 토리에 save
                deliveryStatusRepository.save(deliveryStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookCompleted_then_UPDATE_3(
        @Payload CookCompleted cookCompleted
    ) {
        try {
            if (!cookCompleted.validate()) return;
            // view 객체 조회

            List<DeliveryStatus> deliveryStatusList = deliveryStatusRepository.findByStatus(
                cookCompleted.getStatus()
            );
            for (DeliveryStatus deliveryStatus : deliveryStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deliveryStatus.setOrderId(cookCompleted.getOrderId());
                deliveryStatus.setStatus(cookCompleted.getStatus());
                // view 레파지 토리에 save
                deliveryStatusRepository.save(deliveryStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryfinished_then_UPDATE_4(
        @Payload Deliveryfinished deliveryfinished
    ) {
        try {
            if (!deliveryfinished.validate()) return;
            // view 객체 조회

            List<DeliveryStatus> deliveryStatusList = deliveryStatusRepository.findByStatus(
                deliveryfinished.getStatus()
            );
            for (DeliveryStatus deliveryStatus : deliveryStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deliveryStatus.setOrderId(deliveryfinished.getOrderId());
                deliveryStatus.setStatus(deliveryfinished.getStatus());
                // view 레파지 토리에 save
                deliveryStatusRepository.save(deliveryStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderdropped_then_DELETE_1(
        @Payload Orderdropped orderdropped
    ) {
        try {
            if (!orderdropped.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            deliveryStatusRepository.deleteByStatus(orderdropped.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdercancled_then_DELETE_2(
        @Payload Ordercancled ordercancled
    ) {
        try {
            if (!ordercancled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            deliveryStatusRepository.deleteByStatus(ordercancled.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
