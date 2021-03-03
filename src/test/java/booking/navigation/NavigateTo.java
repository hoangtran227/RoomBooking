package booking.navigation;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class NavigateTo {

    BookingHomePage bookingHomePage;

    private EnvironmentVariables environmentVariables;

    @Step("Open the Booking.com home page")
    public void bookingHomePage() {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        bookingHomePage.openUrl(baseUrl);
    }
}
