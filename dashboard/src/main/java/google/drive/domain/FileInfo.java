package google.drive.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FileInfo_table")
@Data
public class FileInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long fileSize;
    private String fileName;
    private Long index;
    private Boolean uploadStatus;
    private String videoUrl;
}
