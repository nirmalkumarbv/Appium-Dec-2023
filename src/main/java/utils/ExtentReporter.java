package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class ExtentReporter {

    // public ExtentHtmlReporter report;
    public static ExtentSparkReporter sparkReport;
    public static ExtentReports extent;
    public ExtentTest node, test;
    public String testCaseName, testNodes, testDescription, category, authors;

    public void initializeReport() {
        // report = new ExtentHtmlReporter("./reports/result.html");
        sparkReport = new ExtentSparkReporter("./reports/result.html");
        sparkReport.config().setDocumentTitle("Mobile Automation");
        // report.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);
    }

    public ExtentTest initializeTestCase(String testCaseName, String testDescription) {
        test = extent.createTest(testCaseName, testDescription);
        test.assignAuthor(authors);
        test.assignCategory(category);
        return test;
    }

    public ExtentTest initializeTestNodeForEachTC(String testNodes) {
        node = test.createNode(testNodes);
        return node;
    }

    public abstract long takeScreenShot();

    public void reportStep(String desc, String status, boolean bSnap) {

        // MediaEntityModelProvider img = null;
        Media img = null;
        if (bSnap && !status.equalsIgnoreCase("INFO")) {

            long snapNumber = 100000L;
            snapNumber = takeScreenShot();
            try {
                img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".png")
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (status.equalsIgnoreCase("PASS")) {
            node.pass(desc, img);
        } else if (status.equalsIgnoreCase("FAIL")) {
            node.fail(desc, img);
            throw new RuntimeException();
        } else if (status.equalsIgnoreCase("WARNING")) {
            node.warning(desc, img);
        } else if (status.equalsIgnoreCase("INFO")) {
            node.info(desc);
        }
    }

    public void reportStep(String desc, String status) {
        reportStep(desc, status, true);
    }

    public void saveReport() {
        extent.flush();
    }

}