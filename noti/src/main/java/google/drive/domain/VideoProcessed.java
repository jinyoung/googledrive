package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    private Long id;
    private String userid;
    private String fileid;
    private String filename;
    private String fileurl;
    private String filetype;
    // keep

}
