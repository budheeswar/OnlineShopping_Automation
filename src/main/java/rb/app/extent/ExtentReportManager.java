package rb.app.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	 private static ExtentReports extent;
	    private static String reportName = "Test Report";
	    private static String reportPath = "test-output/extent-report.html";

	    private ExtentReportManager() {
	        // Private constructor to prevent instantiation from outside
	    }

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            extent = new ExtentReports();
	            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
	            htmlReporter.config().setDocumentTitle(reportName);
	            htmlReporter.config().setReportName(reportName);
	            htmlReporter.config().setTheme(Theme.DARK);
	            extent.attachReporter(htmlReporter);
	        }
	        return extent;
	    }

	    public static void close() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }
	}
