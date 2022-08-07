package google.drive.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Embeddable
@Data
public class File {

    @Lob
    private String fileName;

    @Lob
    private String file;
}
