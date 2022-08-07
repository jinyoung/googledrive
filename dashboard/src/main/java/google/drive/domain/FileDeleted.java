package google.drive.domain;

import google.drive.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class FileDeleted extends AbstractEvent {

    private Long id;
    private String userId;
}
