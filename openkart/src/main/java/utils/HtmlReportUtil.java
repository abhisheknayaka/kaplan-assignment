package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlReportUtil {

    private static final String REPORT_FILE = System.getProperty("user.dir") + "/results/report.html";

    public static void generateReport(String content) {
        try {
            File reportDir = new File(System.getProperty("user.dir") + "/results");
            if (!reportDir.exists()) reportDir.mkdirs();

            FileWriter writer = new FileWriter(REPORT_FILE, false); // overwrite previous report
            writer.write("<html><head><title>Test Report</title></head><body>");
            writer.write("<h1>OpenCart Parallel Test Results</h1>");
            writer.write(content);
            writer.write("</body></html>");
            writer.close();

            System.out.println("HTML report generated at: " + REPORT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
