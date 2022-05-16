package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span[not(@class='cart-receipt__sum-currency')]")
    private WebElement cartReceiptIcon;

    public int getSumInCart() {
        return Integer.parseInt(cartReceiptIcon.getText());
    }

    public WebElement getCartReceiptIcon(){
        return cartReceiptIcon;
    }

}
