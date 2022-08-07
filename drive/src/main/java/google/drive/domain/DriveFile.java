package google.drive.domain;

import google.drive.DriveApplication;
import google.drive.domain.FileDeleted;
import google.drive.domain.FileStarred;
import google.drive.domain.FilesUploaded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DriveFile_table")
@Data
public class DriveFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;

    private String userId;

    private String fileUrl;

    private String fileSize;

    private String fileType;

    private String uploadStatus;

    private Date regDate;

    private Boolean starred;

    @Embedded
    @AttributeOverride(
        name = "file",
        column = @Column(name = "fileFile", nullable = true)
    )
    private File file;

    @PostPersist
    public void onPostPersist() {
        FilesUploaded filesUploaded = new FilesUploaded(this);
        filesUploaded.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        FileStarred fileStarred = new FileStarred(this);
        fileStarred.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        FileDeleted fileDeleted = new FileDeleted(this);
        fileDeleted.publishAfterCommit();
    }

    public static DriveFileRepository repository() {
        DriveFileRepository driveFileRepository = DriveApplication.applicationContext.getBean(
            DriveFileRepository.class
        );
        return driveFileRepository;
    }

    public void upload() {}

    public void star() {
        FileStarred fileStarred = new FileStarred(this);
        fileStarred.publishAfterCommit();
    }
}
