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
@Table(name = "File_table")
@Data
public class File {

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

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }

    public void upload() {}

    public void star() {
        FileStarred fileStarred = new FileStarred(this);
        fileStarred.publishAfterCommit();
    }
}
