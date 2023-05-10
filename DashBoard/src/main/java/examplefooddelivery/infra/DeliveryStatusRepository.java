package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "deliveryStatuses",
    path = "deliveryStatuses"
)
public interface DeliveryStatusRepository
    extends PagingAndSortingRepository<DeliveryStatus, Long> {
    List<DeliveryStatus> findByStatus(String status);

    void deleteByStatus(String status);
}
