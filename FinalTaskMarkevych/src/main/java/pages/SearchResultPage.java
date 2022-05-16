package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {




    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button']")
    private List<WebElement> addProductToCartButtonList;

    @FindBy(xpath = "//option[@class='ng-star-inserted']")
    private List<WebElement> productSortOptionsList;

    @FindBy(xpath = "//select[@_ngcontent-rz-client-c184]")
    private WebElement productSortOptionsButton;

    @FindBy(xpath = "//rz-cart/button[@type='button']")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button'][1]")
    private WebElement addProductToCartPanel;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickProductSortOptionsButton(){ productSortOptionsButton.click(); }

    public void sortProductsByLowestPrice(){ productSortOptionsList.get(0).click(); }

    public void addFirstProductToCart(){
        //waitReadyStatementOfElement(50, addProductToCartButtonList.get(0));
        addProductToCartButtonList.get(0).click();
    }

    public void clickCartButton(){
        cartButton.click();
    }

}
