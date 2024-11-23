
public class ExtentReport {
	
	public static void setUp() {
		
		ExtentSparkReporter sparkReporter= new ExtentSparkreporter("/Users/athiramoorthy/eclipse-workspace/Automate/target");
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
	}

}
