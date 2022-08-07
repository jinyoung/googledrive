package google.drive.infra;

import google.drive.domain.*;
import google.drive.domain.usecase.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/files")
@Transactional
public class FileController {

    @Autowired
    FileCommand fileCommand;

    @RequestMapping(
        value = "/",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public File upload(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody File file
    ) throws Exception {
        System.out.println("##### /file/upload  called #####");
        fileCommand.upload();
        return file;
    }

    @RequestMapping(
        value = "/{id}/star",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public File star(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /file/star  called #####");
        Optional<File> optionalFile = fileRepository.findById(id);

        optionalFile.orElseThrow(() -> new Exception("No Entity Found"));
        File file = optionalFile.get();
        fileCommand.star();

        return file;
    }
}
