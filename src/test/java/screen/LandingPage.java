package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class LandingPage {

    @FindBy(xpath="//a[@href='/Hotels']")
    @CacheLookup
    public WebElement hotels;

    @FindBy(xpath="(//input[@type='search' and @title ='Search'])[3]")
    @CacheLookup
    public WebElement destination;

    @FindBy(xpath="//div[@class='ui_columns is-mobile result-content-columns']")
    @CacheLookup
    public List<WebElement> hotelList;

    @FindBy(xpath="//a[@href='/Attractions']")
    @CacheLookup
    public WebElement thingsToDo;

    @FindBy(xpath="//a[@href='/Articles']")
    @CacheLookup
    public WebElement travelStories;

    @FindBy(xpath="//button[@class='BrOJk u j z _F wSSLS tIqAi unMkR']")
    @CacheLookup
    public WebElement NextStory;

    @FindBy(xpath="(//*[text()='Read more'])[1]")
    @CacheLookup
    public WebElement readMore;
}
