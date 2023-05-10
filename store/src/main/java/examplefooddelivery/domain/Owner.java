package examplefooddelivery.domain;

import examplefooddelivery.StoreApplication;
import examplefooddelivery.domain.CookCompleted;
import examplefooddelivery.domain.Orderdropped;
import examplefooddelivery.domain.Ordertaked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Owner_table")
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String storeName;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Ordertaked ordertaked = new Ordertaked(this);
        ordertaked.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        CookCompleted cookCompleted = new CookCompleted(this);
        cookCompleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        Orderdropped orderdropped = new Orderdropped(this);
        orderdropped.publishAfterCommit();
    }

    public static OwnerRepository repository() {
        OwnerRepository ownerRepository = StoreApplication.applicationContext.getBean(
            OwnerRepository.class
        );
        return ownerRepository;
    }

    public static void payment(Ordered ordered) {
        /** Example 1:  new item 
        Owner owner = new Owner();
        repository().save(owner);

        Ordertaked ordertaked = new Ordertaked(owner);
        ordertaked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(owner->{
            
            owner // do something
            repository().save(owner);

            Ordertaked ordertaked = new Ordertaked(owner);
            ordertaked.publishAfterCommit();

         });
        */

    }

    public static void cookingStart(Ordertaked ordertaked) {
        /** Example 1:  new item 
        Owner owner = new Owner();
        repository().save(owner);

        CookCompleted cookCompleted = new CookCompleted(owner);
        cookCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordertaked.get???()).ifPresent(owner->{
            
            owner // do something
            repository().save(owner);

            CookCompleted cookCompleted = new CookCompleted(owner);
            cookCompleted.publishAfterCommit();

         });
        */

    }
}
