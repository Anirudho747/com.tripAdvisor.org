package steps;

import base.Generics;
import base.LogUtility;
import screen.HotelBooking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import testCase.Hotels;


public class HotelBookingSteps extends HotelBooking {

    public WebDriver driver;
    private LogUtility logUtility;

    public HotelBookingSteps(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        logUtility = new LogUtility(HotelBookingSteps.class);
    }

    public void selectDates()
    {
        Generics.switchTabs();
        hotelName.click();
        start.click();
        checkIn.click();
        checkOut.click();
    }

    public void selectRoom()
    {
        update.click();
    }

    public void selectDeal()
    {
         viewDeal.click();
    }

    public void showRating()
    {
       Generics.switchTabs();
       logUtility.logInfo("This activity has got a review of "+ratings.getText()+"stars from "+reviews.getText());
    }

}
