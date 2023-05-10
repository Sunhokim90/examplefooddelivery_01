package examplefooddelivery.domain;

import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Orderdropped extends AbstractEvent {

    private Long id;
    private String orderID;
    private String storeName;
    private String status;
}
