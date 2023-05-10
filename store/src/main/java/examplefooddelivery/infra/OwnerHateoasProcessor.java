package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OwnerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Owner>> {

    @Override
    public EntityModel<Owner> process(EntityModel<Owner> model) {
        return model;
    }
}
