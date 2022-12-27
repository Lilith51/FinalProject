package Amazon;
import AmazonStepObject.StepObject;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;
public class FilterPriceRange extends StepObject {
    StepObject checkMethods = new StepObject();
    @Test
    public void filterByPriceRange(){
        hamMenu.click();
        sleep(2000);
        checkMethods.childNavigator("Electronics", 2);
        sleep(2000);
        minPrice.setValue("100");
        maxPrice.setValue("250");

        checkMethods.fetchBrands( true,false, "apple");

        checkMethods.checkPriceRange(minPrice.getValue(), maxPrice.getValue());

        checkMethods.fetchBrands( false,false, "apple");
        softAssert.assertAll();
    }
}
