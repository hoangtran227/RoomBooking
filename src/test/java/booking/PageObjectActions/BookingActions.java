package booking.PageObjectActions;


import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.ArrayList;
import booking.TestData;

public class BookingActions extends UIInteractionSteps {

    static By BTN_SIGNIN = By.cssSelector("a.js-header-login-link:nth-child(2) > span:nth-child(1)");
    static By BTN_GOOGLE = By.cssSelector("a.access-panel__social-button:nth-child(2)");
    static By EMAIL = By.id("identifierId");
    static By PASSWORD = By.xpath("//input[@name='password']");
    static By DEST = By.cssSelector("#ss");
    static By DATE = By.cssSelector(".xp__dates__checkin > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)");
    static By START = By.cssSelector("div.bui-calendar__wrapper:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(6)");
    static By END = By.cssSelector("div.bui-calendar__wrapper:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(1)");
    static By GUESS_COUNT = By.cssSelector(".xp__guests__count");
    static By SEARCH = By.cssSelector(".sb-searchbox__button > span:nth-child(1)");
    static By RESULT = By.xpath("//div[@aria-label='Search results']/div[5]/div[2]/div/div/div/h3/a");
    static By CHEAPEST_ROOM = By.xpath("//tbody/tr[1]/td[5]/div/select");
    static By CHEAPEST_PRICE = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr[1]/td[3]/div/div/div[1]/div[2]/div");
    static By RESERVE = By.cssSelector(".js-reservation-button__text");
    static By NUM_OF_ADULT = By.xpath("//select[@id='group_adults']/option[@selected]");
    static By NUM_OF_CHILDREN = By.xpath("//select[@id='group_children']/option[@selected]");
    static By NUM_OF_ROOM = By.xpath("//select[@id='no_rooms']/option[@selected]");
    static By CHECK_IN_DATE = By.xpath("//div[@data-placeholder='Check-in Date']");
    static By CHECK_OUT_DATE = By.xpath("//div[@data-placeholder='Check-out Date']");
    static By FIRST_NAME = By.cssSelector("#firstname");
    static By LAST_NAME = By.cssSelector("#lastname");
    static By EMAIL_GUESS = By.cssSelector("#email");
    static By BTN_NEXT_FINAL_DETAIL = By.xpath("//*[@id=\"bookForm\"]/div[5]/div/div[2]/button/span[1]");
    static By START_CONFIRM = By.xpath("//div[text()='Check-in']/following-sibling::time/span[1]");
    static By END_CONFIRM = By.xpath("//div[text()='Check-out']/following-sibling::time/span[1]");
    static By PRICE_CONFIRM = By.xpath("//span[@data-animate-price-group-name='bp_user_total_price']");
    static By ROOM_TYPE = By.xpath("//tbody/tr[1]/td[1]/div/div[1]/a[2]/span");

    String cheapest_price;
    String room_type;


    @Step("click button signin")
    public void clickButtonSignIn() {
        $(BTN_SIGNIN).click();
    }

    @Step("click google icon and sign in with my google account")
    public void clickGoogleIconAndSignIn() {
        String winHandleBefore = getDriver().getWindowHandle();
        $(BTN_GOOGLE).click();
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
        $(EMAIL).typeAndEnter(TestData.email);
        $(PASSWORD).typeAndEnter(TestData.password);
        getDriver().switchTo().window(winHandleBefore);
    }

    @Step("add the information of the jouney")
    public void addTheInformationOfTheJourney() {
        $(DEST).type(TestData.dest);
        $(DATE).click();
        $(START).click();
        $(END).click();
        $(GUESS_COUNT).click();
    }

    @Step("click search")
    public void clickSearch() {
        $(SEARCH).click();
        Assert.assertTrue($(DEST).getAttribute("value").contains(TestData.dest));
        Assert.assertEquals(TestData.start_date, $(CHECK_IN_DATE).getText());
        Assert.assertEquals(TestData.end_date, $(CHECK_OUT_DATE).getText());
        Assert.assertEquals(TestData.adult_count, $(NUM_OF_ADULT).getAttribute("value"));
        Assert.assertEquals(TestData.child_count, $(NUM_OF_CHILDREN).getAttribute("value"));
        Assert.assertEquals(TestData.room_count, $(NUM_OF_ROOM).getAttribute("value"));
    }

    @Step("click 5th result")
    public void click5thResult() {
        $(RESULT).click();
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
    }

    @Step("choose the cheapest room")
    public void chooseTheCheapestRoom() {
        $(CHEAPEST_ROOM).selectByValue(TestData.room_count);
        cheapest_price = $(CHEAPEST_PRICE).getText();
        room_type = $(ROOM_TYPE).getText();
        $(RESERVE).click();
        Assert.assertEquals(TestData.first_name, $(FIRST_NAME).getAttribute("value"));
        Assert.assertEquals(TestData.last_name, $(LAST_NAME).getAttribute("value"));
        Assert.assertEquals(TestData.email, $(EMAIL_GUESS).getAttribute("value"));
    }

    @Step("click next final detail")
    public void clickNextFinalDetail() {
        $(BTN_NEXT_FINAL_DETAIL).click();
        Assert.assertEquals(TestData.start_confirm, $(START_CONFIRM).getText());
        Assert.assertEquals(TestData.end_confirm, $(END_CONFIRM).getText());
        Assert.assertEquals(cheapest_price, $(PRICE_CONFIRM).getText());
    }

}


