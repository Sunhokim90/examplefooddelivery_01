package examplefooddelivery.domain;

import examplefooddelivery.RiderApplication;
import examplefooddelivery.domain.Deliveryfinished;
import examplefooddelivery.domain.Riderfinded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Rider_table")
@Data
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String riderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Riderfinded riderfinded = new Riderfinded(this);
        riderfinded.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Deliveryfinished deliveryfinished = new Deliveryfinished(this);
        deliveryfinished.publishAfterCommit();
    }

    public static RiderRepository repository() {
        RiderRepository riderRepository = RiderApplication.applicationContext.getBean(
            RiderRepository.class
        );
        return riderRepository;
    }

    public static void pickupNotify(Riderfinded riderfinded) {
        /** Example 1:  new item 
        Rider rider = new Rider();
        repository().save(rider);

        Deliveryfinished deliveryfinished = new Deliveryfinished(rider);
        deliveryfinished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(riderfinded.get???()).ifPresent(rider->{
            
            rider // do something
            repository().save(rider);

            Deliveryfinished deliveryfinished = new Deliveryfinished(rider);
            deliveryfinished.publishAfterCommit();

         });
        */

    }

    public static void findRider(CookCompleted cookCompleted) {
        /** Example 1:  new item 
        Rider rider = new Rider();
        repository().save(rider);

        Riderfinded riderfinded = new Riderfinded(rider);
        riderfinded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookCompleted.get???()).ifPresent(rider->{
            
            rider // do something
            repository().save(rider);

            Riderfinded riderfinded = new Riderfinded(rider);
            riderfinded.publishAfterCommit();

         });
        */

    }
}
