package examplefooddelivery.domain;

import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private String cutomerID;
    private String storeName;
    private String selectManu;
    private Integer price;
    private String status;
}
