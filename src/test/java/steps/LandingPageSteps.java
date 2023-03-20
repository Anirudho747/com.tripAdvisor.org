package steps;

import org.openqa.selenium.Keys;

import java.util.Set;
import screen.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



public class LandingPageSteps extends LandingPage {

    public WebDriver driver;

    public LandingPageSteps(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void selectCity(String city) {
        hotels.click();
        destination.click();
        destination.sendKeys(city);
        destination.sendKeys(Keys.ENTER);
    }

    public void selectActivity(String activity) {
        thingsToDo.click();
        destination.click();
        destination.sendKeys(activity);
        destination.sendKeys(Keys.ENTER);
    }

    public void selectStory(int item) {
        travelStories.click();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<item;i++)
        {
            NextStory.click();
        }
       readMore.click();
    }

    public void selectHotel(int number)
    {
        int i=0;
        for(WebElement e : hotelList) {
            i++;
            if(i==number)
            {
                e.click();
            }
        }
    }

}
