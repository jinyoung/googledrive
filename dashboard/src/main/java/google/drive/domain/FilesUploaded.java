package google.drive.domain;

import google.drive.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class FilesUploaded extends AbstractEvent {

    private Long id;
    private String filename;
    private String userId;
    private String file;
    private String fileUrl;
    private String fileSize;
    private String fileType;
    private String uploadStatus;
}
