package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FilesUploaded extends AbstractEvent {

    private Long id;
    private String filename;
    private String userId;
    private String file;
    private String fileUrl;
    private String fileSize;
    private String fileType;
    private String uploadStatus;

    public FilesUploaded(File aggregate) {
        super(aggregate);
    }

    public FilesUploaded() {
        super();
    }
    // keep

}
