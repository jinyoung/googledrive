package google.drive.domain;

import google.drive.infra.AbstractEvent;
import java.util.Date;

public class FileDeleted extends AbstractEvent {

    private Long id;
    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
