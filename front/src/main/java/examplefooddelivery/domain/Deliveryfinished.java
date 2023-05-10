package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Deliveryfinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String riderId;
    private String status;
}
