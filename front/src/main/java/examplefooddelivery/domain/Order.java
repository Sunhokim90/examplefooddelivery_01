package examplefooddelivery.domain;

import examplefooddelivery.FrontApplication;
import examplefooddelivery.domain.Ordercancled;
import examplefooddelivery.domain.Ordered;
import examplefooddelivery.domain.SmSsended;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cutomerId;

    private String storeName;

    private String selectManu;

    private Integer price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

        SmSsended smSsended = new SmSsended(this);
        smSsended.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        Ordercancled ordercancled = new Ordercancled(this);
        ordercancled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void ifdontstartcook(Ordercancled ordercancled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordercancled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void statusupdate(Orderdropped orderdropped) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        SmSsended smSsended = new SmSsended(order);
        smSsended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderdropped.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            SmSsended smSsended = new SmSsended(order);
            smSsended.publishAfterCommit();

         });
        */

    }

    public static void statusupdate(Ordertaked ordertaked) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        SmSsended smSsended = new SmSsended(order);
        smSsended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordertaked.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            SmSsended smSsended = new SmSsended(order);
            smSsended.publishAfterCommit();

         });
        */

    }

    public static void statusupdate(CookCompleted cookCompleted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        SmSsended smSsended = new SmSsended(order);
        smSsended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookCompleted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            SmSsended smSsended = new SmSsended(order);
            smSsended.publishAfterCommit();

         });
        */

    }

    public static void statusupdate(Riderfinded riderfinded) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        SmSsended smSsended = new SmSsended(order);
        smSsended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(riderfinded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            SmSsended smSsended = new SmSsended(order);
            smSsended.publishAfterCommit();

         });
        */

    }

    public static void statusupdate(Deliveryfinished deliveryfinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        SmSsended smSsended = new SmSsended(order);
        smSsended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryfinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            SmSsended smSsended = new SmSsended(order);
            smSsended.publishAfterCommit();

         });
        */

    }
}
