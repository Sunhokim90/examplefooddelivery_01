package examplefooddelivery.domain;

import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Riderfinded extends AbstractEvent {

    private Long id;
    private String orderID;
    private String riderID;
    private String status;
}
