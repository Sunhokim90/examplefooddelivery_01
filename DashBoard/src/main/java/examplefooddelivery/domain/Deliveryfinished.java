package examplefooddelivery.domain;

import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Deliveryfinished extends AbstractEvent {

    private Long id;
    private String orderID;
    private String riderID;
    private String status;
}
