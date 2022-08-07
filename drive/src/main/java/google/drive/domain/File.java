package google.drive.domain;

import google.drive.DriveApplication;
import google.drive.domain.FileDeleted;
import google.drive.domain.FileStarred;
import google.drive.domain.FilesUploaded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "File_table")
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

    private File file;

    @PostPersist
    public void onPostPersist() {
        FilesUploaded filesUploaded = new FilesUploaded();
        BeanUtils.copyProperties(this, filesUploaded);
        filesUploaded.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        FileStarred fileStarred = new FileStarred();
        BeanUtils.copyProperties(this, fileStarred);
        fileStarred.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        FileDeleted fileDeleted = new FileDeleted();
        BeanUtils.copyProperties(this, fileDeleted);
        fileDeleted.publishAfterCommit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void Upload() {}
}
