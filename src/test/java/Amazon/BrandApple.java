package Amazon;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
public class BrandApple extends StepObject {
    StepObject checkMethods = new StepObject();
    @Test
    public void checkIfAppleCheckboxAppear(){
        hamMenu.click();
        sleep(1000);
        checkMethods.childNavigator("Electronics", 2);
        checkMethods.fetchBrands( true,true, "apple");
        checkMethods.checkBrandsCheckbox( "apple");
        checkMethods.checkForBrand( "apple" );
        softAssert.assertAll();
    }

    @Test
    public void checkIfProductShippable(){
        hamMenu.click();
        sleep(1000);
        checkMethods.childNavigator("Electronics", 2);
        checkMethods.fetchBrands( true,true, "apple");
        checkMethods.exploreItem(0 );
        addToCart.shouldBe(Condition.disabled);
        addToCartError.shouldBe(visible);
        System.out.println(addToCartError.getText());
        softAssert.assertAll();
    }
}
