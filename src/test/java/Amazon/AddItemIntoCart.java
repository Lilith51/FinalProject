package Amazon;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class AddItemIntoCart extends StepObject {
    StepObject checkMethods = new StepObject();
    @Test
    public void addItemIntoCart(){
        hamMenu.click();
        sleep(3000);
        checkMethods.childNavigator("Electronics", 4);
        checkMethods.exploreItem(0 );
        activeAddToCart.click();
        sleep(2000);
        checkMethods.cartButtonExists();
        String itemsQuantity = itemsQuantittyInCart.getText();
        String itemsQuantityInHeader = cartItemsQuantityInHeader.getText();
        boolean checkQuantity = itemsQuantity.equals(itemsQuantityInHeader);
        softAssert.assertTrue(checkQuantity);
        softAssert.assertAll();
    }
}
