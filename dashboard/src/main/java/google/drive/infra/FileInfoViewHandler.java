package google.drive.infra;

import google.drive.config.kafka.KafkaProcessor;
import google.drive.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class FileInfoViewHandler {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFilesUploaded_then_CREATE_1(
        @Payload FilesUploaded filesUploaded
    ) {
        try {
            if (!filesUploaded.validate()) return;

            // view 객체 생성
            FileInfo fileInfo = new FileInfo();
            // view 객체에 이벤트의 Value 를 set 함
            fileInfo.setId(filesUploaded.getId());
            fileInfo.setFileSize(Long.valueOf(filesUploaded.getFileSize()));
            fileInfo.setFileName(filesUploaded.getFilename());
            fileInfo.setUploadStatus(true);
            // view 레파지 토리에 save
            fileInfoRepository.save(fileInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProcessed_then_UPDATE_1(
        @Payload VideoProcessed videoProcessed
    ) {
        try {
            if (!videoProcessed.validate()) return;
            // view 객체 조회
            Optional<FileInfo> fileInfoOptional = fileInfoRepository.findById(
                Long.valueOf(videoProcessed.getFileid())
            );

            if (fileInfoOptional.isPresent()) {
                FileInfo fileInfo = fileInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                fileInfo.setVideoUrl(videoProcessed.getFileurl());
                // view 레파지 토리에 save
                fileInfoRepository.save(fileInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileDeleted_then_UPDATE_2(
        @Payload FileDeleted fileDeleted
    ) {
        try {
            if (!fileDeleted.validate()) return;
            // view 객체 조회
            Optional<FileInfo> fileInfoOptional = fileInfoRepository.findById(
                fileDeleted.getId()
            );

            if (fileInfoOptional.isPresent()) {
                FileInfo fileInfo = fileInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                fileInfo.setUploadStatus(false);
                // view 레파지 토리에 save
                fileInfoRepository.save(fileInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
