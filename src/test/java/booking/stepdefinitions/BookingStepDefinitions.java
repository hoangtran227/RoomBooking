package booking.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import booking.PageObjectActions.BookingActions;
import booking.navigation.NavigateTo;

public class BookingStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    BookingActions challengeActions;


    @Given("I am on the Booking home page")
    public void i_am_on_the_booking_com_home_page() {
        navigateTo.bookingHomePage();
    }

    @When("click on button Sign In")
    public void i_click_on_button_sign_in() { challengeActions.clickButtonSignIn();}

    @When("click google icon and sign in with my google account")
    public void i_click_google_icon_and_sign_in() { challengeActions.clickGoogleIconAndSignIn();}

    @When("add the information of the destination")
    public void i_add_the_information_of_the_journey() { challengeActions.addTheInformationOfTheJourney();}

    @When("click search")
    public void i_click_search() { challengeActions.clickSearch();}

    @When("click 5th result")
    public void i_click_5th_result() { challengeActions.click5thResult();}

    @When("choose the cheapest price")
    public void i_choose_the_cheapest_room() { challengeActions.chooseTheCheapestRoom();}

    @When("click next final detail")
    public void i_click_next_final_detail() { challengeActions.clickNextFinalDetail();}
}
