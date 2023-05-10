package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Riderfinded extends AbstractEvent {

    private Long id;
    private String orderId;
    private String riderId;
    private String status;

    public Riderfinded(Rider aggregate) {
        super(aggregate);
    }

    public Riderfinded() {
        super();
    }
}
