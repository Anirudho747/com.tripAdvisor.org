package base;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Generics extends BaseClass{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static JavascriptExecutor js = (JavascriptExecutor) driver; 
	public static Actions action = new Actions(driver);
	
	public static boolean isElementPresent(WebElement element,int timeout)
	{
		boolean found = false;
		try
		{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		found=true;
		}
		catch(Exception e)
		{
		 System.out.println(e.getMessage());
		}
		return found;
	}

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void typeText(WebElement element, String Text)
	{
		element.click();
		element.clear();
		element.sendKeys(Text);
	}
	
	public static void typeKeys(WebElement element, Keys key)
	{
		element.click();
		element.clear();
		element.sendKeys(key);
	}
	
	public static void clickElement(WebElement element)
	{
			element.click();	
	}
	
	public static String getAttribute(WebElement element, String Attribute)
	{
		return element.getAttribute(Attribute);
	}
	
	public static String getCSS(WebElement element, String CSS)
	{
		return element.getCssValue(CSS);
	}
	
	public static String getText(WebElement element)
	{
		return element.getText();
	}
	
	public static void selectDropDownValue(WebElement element,String type,String value)
	{
		By newelement = toByVal(element);
		
		Select select  = new Select(driver.findElement(newelement));
		
		switch(type)
		{
		case "index" : 
					  select.selectByIndex(Integer.parseInt(value));
					  break;
		case "value" :
					  select.selectByValue(value);	
					  break;
		case "visible_text" : 
					  select.selectByVisibleText(value);	
					  break;
					  
		default:
						System.out.println("Enter Valid Value"); 
						break;
		}
	}
	
	public static void moveToElement(WebElement element)
	{
		action.moveToElement(element).perform();
	}
	
	public static void doubleClick(WebElement element)
	{
		action.doubleClick(element).perform();
	}
	
	public static void leftClick(WebElement element)
	{
		action.click(element).perform();
	}	
	
	public static void rightClick(WebElement element)
	{
		action.contextClick(element).perform();
	}
	
	public static void doubleClick()
	{
		action.doubleClick().perform();
	}
	
	public static void leftClick()
	{
		action.click().perform();
	}	
	
	public static void rightClick()
	{
		action.contextClick().perform();
	}
	
	public static void moveElement(WebElement from,WebElement to)
	{
		action.dragAndDrop(from, to).perform();
	}
	
	public static void moveElementBy(WebElement from,int x,int y)
	{
		action.dragAndDropBy(from, x, y).perform();
	}
	
	public static void keyUp(WebElement element,Keys key)
	{
		action.keyUp(element,key).perform();
	}
	
	public static void keyUp(Keys key)
	{
		action.keyUp(key).perform();
	}
	
	public static void keyDown(WebElement element,Keys key)
	{
		action.keyDown(element,key).perform();
	}
	
	public static void keyDown(Keys key)
	{
		action.keyDown(key).perform();
	}
	
	public static void moveByOffset(int x,int y)
	{
		action.moveByOffset(x, y).perform();
	}
	
	public static void release()
	{
		action.release().perform();
	}
	
	public static void release(WebElement element)
	{
		action.release(element).perform();
	}
	
	public static void scroll(int x,int y)
	{
		js.executeScript("window.scrollBy(x,y)");
	}
	
	public static void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public static void scrollFullPage(WebElement element)
	{
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void captureAlertMessage()
	{
		driver.switchTo().alert().getText();
	}
	
	public static void sendMessageToAlert(String msg)
	{
		driver.switchTo().alert().sendKeys(msg);
	}
	
	public static void refresh()
	{
		driver.navigate().refresh();
	}
	
	public static String getTitle()
	{
		return driver.getTitle();
	}

	public static void switchTabs()
	{
		String currentHandle= driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String actual: handles)
		{
			if (!actual.equalsIgnoreCase(currentHandle))
				driver.switchTo().window(actual);
		}
	}
	
	public static By toByVal(WebElement we) {
	    // By format = "[foundFrom] -> locator: term"
	    // see RemoteWebElement toString() implementation
		System.out.println(we);
	    String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
	    String locator = data[0];
	    String term = data[1];

	    switch (locator) {
	    case "xpath":
	        return By.xpath(term);
	    case "css selector":
	        return By.cssSelector(term);
	    case "id":
	        return By.id(term);
	    case "tag name":
	        return By.tagName(term);
	    case "name":
	        return By.name(term);
	    case "link text":
	        return By.linkText(term);
	    case "class name":
	        return By.className(term);
	    }
	    return (By) we;
	}
}
