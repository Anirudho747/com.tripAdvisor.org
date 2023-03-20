package testCase;


import base.BaseClass;
import base.LogUtility;
import org.testng.annotations.Test;
import steps.LandingPageSteps;
import steps.HotelBookingSteps;

public class Activities extends BaseClass {

   public LandingPageSteps lpSteps;
   public HotelBookingSteps hbSteps;
   private LogUtility logUtility;

    public Activities()
    {
        super();
        lpSteps = new LandingPageSteps(driver);
        hbSteps = new HotelBookingSteps(driver);
        logUtility = new LogUtility(Activities.class);

    }



    @Test (enabled=true,priority=1)
    public void bookActivity()
    {
        logUtility.logTestTitle("Second Module");
        logUtility.logTestInfo("Info");
        lpSteps.selectActivity("Darjeeling");
        lpSteps.selectHotel(7);
        hbSteps.showRating();
    }


}
