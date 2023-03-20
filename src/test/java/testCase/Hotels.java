package testCase;

import base.BaseClass;
import base.LogUtility;
import org.testng.annotations.Test;
import steps.HotelBookingSteps;
import steps.LandingPageSteps;

public class Hotels extends BaseClass {

    public LandingPageSteps lpSteps;
    public HotelBookingSteps hbSteps;
    private LogUtility logUtility;

    public Hotels()
    {
        super();
        lpSteps = new LandingPageSteps(driver);
        hbSteps = new HotelBookingSteps(driver);
        logUtility = new LogUtility(Hotels.class);

    }


    @Test(enabled=true,priority=20)
    public void bookHotel()
    {
        logUtility.logTestTitle(cr.getBrowser());
        logUtility.logTestInfo(cr.getURL());
        lpSteps.selectCity("Digha");
        lpSteps.selectHotel(5);
        hbSteps.selectDates();
        hbSteps.selectRoom();
        //  hbSteps.selectDeal();
    }
}
