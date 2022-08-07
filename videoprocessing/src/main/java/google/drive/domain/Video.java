package google.drive.domain;

import google.drive.VideoprocessingApplication;
import google.drive.domain.VideoProcessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String fileurl;

    private String filename;

    private String filetype;

    private String userid;

    private String fileid;

    @PostPersist
    public void onPostPersist() {
        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoprocessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void processVideo(FilesUploaded filesUploaded) {
        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        */

        /** Example 2:  finding and process
        
        repository().findById(filesUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);


         });
        */

    }
}
