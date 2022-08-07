package google.drive.infra;

import google.drive.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DriveFileHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DriveFile>> {

    @Override
    public EntityModel<DriveFile> process(EntityModel<DriveFile> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/star")
                .withRel("star")
        );

        return model;
    }
}
