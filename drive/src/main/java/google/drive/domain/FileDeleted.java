package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileDeleted extends AbstractEvent {

    private Long id;
    private String userId;

    public FileDeleted(DriveFile aggregate) {
        super(aggregate);
    }

    public FileDeleted() {
        super();
    }
    // keep

}
