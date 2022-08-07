package google.drive.domain.usecase;

import google.drive.FileApplication;
import google.drive.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileCommand {

    @Autowired
    FileRepository fileRepository;

    public void upload() {}

    public void star() {
        FileStarred fileStarred = new FileStarred();
        /*
        Input Event Content
        */
        fileStarred.publishAfterCommit();
    }
}
