package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookCompleted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String storeName;
    private String status;

    public CookCompleted(Owner aggregate) {
        super(aggregate);
    }

    public CookCompleted() {
        super();
    }
}
