package google.drive.common;

import google.drive.VideoprocessingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { VideoprocessingApplication.class })
public class CucumberSpingConfiguration {}
