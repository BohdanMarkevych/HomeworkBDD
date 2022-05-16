package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ShoppingCartPage shoppingCartPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User makes search by keyword {string}")
    public void makeSearchByKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.searchByKeyword(keyword);
    }

    @And("User clicks product sort options button")
    public void clickProductSortOptionsButton() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(50);
        searchResultPage.implicitWait(50);
        searchResultPage.clickProductSortOptionsButton();
    }

    @And("User sorts products by lowest price")
    public void sortProductsByLowestPrice() {
        searchResultPage.sortProductsByLowestPrice();
    }

    @And("User adds first product to cart")
    public void addFirstProductToCart() {
        searchResultPage.implicitWait(DEFAULT_TIMEOUT);
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.addFirstProductToCart();
    }

    @And("User clicks cart button")
    public void userClicksCartButton() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickCartButton();
    }

    @Then("User checks that sum in cart is lower than {long}")
    public void checkThatSumInCartIsLowerThanExpected(long expectedSum) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        searchResultPage.waitVisibilityOfElement(20, shoppingCartPage.getCartReceiptIcon());
        Assert.assertTrue(shoppingCartPage.getSumInCart() < expectedSum);
    }

    @After
    public void tearDown() {
        driver.close();
    }


}




