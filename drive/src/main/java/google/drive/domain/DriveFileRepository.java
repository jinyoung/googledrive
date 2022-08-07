package google.drive.domain;

import google.drive.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "driveFiles",
    path = "driveFiles"
)
public interface DriveFileRepository
    extends PagingAndSortingRepository<DriveFile, Long> {}
