package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileStarred extends AbstractEvent {

    private Long id;
    private String filename;
    private String userId;
    private String file;
    private String fileUrl;
    private String fileSize;
    private String fileType;
    private String uploadStatus;
    private Date regDate;
    private Boolean starred;

    public FileStarred(File aggregate) {
        super(aggregate);
    }

    public FileStarred() {
        super();
    }
    // keep

}
