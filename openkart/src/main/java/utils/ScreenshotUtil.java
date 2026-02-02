package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "/results/screenshots/";


    private static void prepareFolder() {
        File dir = new File(SCREENSHOT_DIR);
        if (dir.exists()) {
            try {
                FileUtils.cleanDirectory(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            dir.mkdirs();
        }
    }

    public static void takeScreenshot(WebDriver driver, String testName) {
        prepareFolder();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = SCREENSHOT_DIR + testName + ".png"; // overwrite latest

        try {
            FileUtils.copyFile(source, new File(destinationPath));
            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot");
            e.printStackTrace();
        }
    }
}
