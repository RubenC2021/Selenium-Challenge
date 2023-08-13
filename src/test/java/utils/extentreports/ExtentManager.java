package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;

import java.io.File;


@Slf4j
public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String REPORT_FILE_NAME = "report.html";
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String REPORT_FILE_PATH =
            USER_DIR + FILE_SEPARATOR + "target" + FILE_SEPARATOR + "extent-reports";
    private static final String REPORT_FILE_LOCATION = REPORT_FILE_PATH + FILE_SEPARATOR + REPORT_FILE_NAME;

    public synchronized static ExtentReports createExtentReports() {
        String fileName = getReportPath(REPORT_FILE_PATH);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setDocumentTitle(" Automation Report");
        extentReports.attachReporter(htmlReporter);

        return extentReports;
    }

    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                log.info("Directory: " + path + " is created!");
                return REPORT_FILE_LOCATION;
            } else {
                log.debug("Failed to create directory: " + path);
                return USER_DIR;
            }
        } else {
            log.info("Directory already exists: " + path);
        }
        return REPORT_FILE_LOCATION;
    }


}
