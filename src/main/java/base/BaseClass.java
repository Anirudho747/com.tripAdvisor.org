package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class BaseClass {
	
    public static WebDriver driver = null;
	public ConfigReader cr = new ConfigReader();
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	

	
	public BaseClass()
	{
		driver = SingletonDriver.getSingleInstance();
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
	}
	
	  @BeforeClass
	    public void setUp()
	    {
	        if(cr.getBrowser().equalsIgnoreCase("Edge"))
	        {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }
	        else if (cr.getBrowser().equalsIgnoreCase("mozilla"))
	        {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }

			driver.get(cr.getURL());
	        driver.manage().window().maximize();
	        extent.attachReporter(spark);
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(160));

			driver.manage().timeouts().pageLoadTimeout(700, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);

	    }

	    @AfterClass
	    public void tearDown()
	    {
	    	extent.flush();
	        driver.close();
	    }


}
