package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HotelBooking {

    @FindBy(xpath="//*[@id='HEADING']")
    @CacheLookup
    public WebElement hotelName;

    @FindBy(xpath="//*[@data-test-target='picker-CHECKIN']")
    @CacheLookup
    public WebElement start;

    @FindBy(xpath="//div[@aria-label='Sat Mar 25 2023']")
    @CacheLookup
    public WebElement checkIn;

    @FindBy(xpath="//div[@aria-label='Mon Mar 27 2023']")
    @CacheLookup
    public WebElement checkOut;

    @FindBy(xpath="//div[@data-automation='guestsUpdateBtn']")
    @CacheLookup
    public WebElement update;

    @FindBy(xpath="(//*[text()='View deal'])[1]")
    @CacheLookup
    public WebElement viewDeal;

    @FindBy(xpath="//*[@class='ZDEqb']")
    @CacheLookup
    public WebElement ratings;

    @FindBy(xpath="//*[@class='AfQtZ']")
    @CacheLookup
    public WebElement reviews;


}
