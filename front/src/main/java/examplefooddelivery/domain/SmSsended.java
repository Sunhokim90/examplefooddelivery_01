package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class SmSsended extends AbstractEvent {

    private Long id;
    private String cutomerId;
    private String storeName;
    private String selectManu;
    private Integer price;
    private String status;

    public SmSsended(Order aggregate) {
        super(aggregate);
    }

    public SmSsended() {
        super();
    }
}
