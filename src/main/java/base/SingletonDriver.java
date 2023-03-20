package base;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonDriver {
	
	private static WebDriver driver;
	
	private SingletonDriver(){
		
	}

	public static WebDriver getSingleInstance()
	{
		if(driver==null)
		{
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
		}
		return driver;
	}
	
}
