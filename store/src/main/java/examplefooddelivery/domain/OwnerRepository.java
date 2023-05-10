package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "owners", path = "owners")
public interface OwnerRepository
    extends PagingAndSortingRepository<Owner, Long> {}
