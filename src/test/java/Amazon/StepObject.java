package Amazon;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.Objects.isNull;

public class StepObject extends DashboardVariables{
    SoftAssert softAssert = new SoftAssert();

    @Step("Open left navigation and choose sub category")
    public void childNavigator(String menu, Integer li) {
        for (SelenideElement mainItemsLi : mainItems) {
            sleep(2000);
            String mainItemsHref = mainItemsLi.getAttribute("href");

            if (!isNull(mainItemsHref) && mainItemsHref.length() == 0 && mainItemsLi.getText().equalsIgnoreCase(menu)) {
                mainItemsLi.click();
                sleep(4000);
                innerDivItems.get(li).click();
                break;
            }
        }
    }

    @Step("Check if passed brand exists and filter by it")
    public void fetchBrands( Boolean assertValue, Boolean isClick, String filteredValue){
        for (SelenideElement brand : brands) {
            boolean match = brand.getText().equalsIgnoreCase(filteredValue);
            if (match) {
                softAssert.assertTrue(assertValue);
            }
            if (isClick) {
                brand.click();
                break;
            }
        }
    }

    @Step("Check if brand's checkbox is checked after picking it")
    public boolean isBoxChecked(SelenideElement brandsCheckboxes){
        return brandsCheckboxes.shouldHave(Condition.checked).getAttribute("checked").equalsIgnoreCase("true");

    }

    @Step("Fetch brand filters")
    public void checkBrandsCheckbox( String filteredValue){
        for(int i = 0; i < brands.size(); i++){
            boolean match = brands.get(i).getText().equalsIgnoreCase(filteredValue);
            if(match) {
                softAssert.assertTrue(isBoxChecked(brandsCheckboxes.get(i-1)));
                break;
            }

        }
    }

    @Step("Check if items are displayed by picked brand")

    public void checkForBrand( String brandName){
        boolean haveBrandText = true;
        for (SelenideElement itemsTitle : itemsTitles) {
            int check = itemsTitle.shouldBe(text(brandName)).getText().toLowerCase().indexOf(brandName);
            if (check == -1) {
                haveBrandText = false;
                break;
            }
        }
        softAssert.assertTrue(haveBrandText);
    }

    @Step("Open specific item")
    public void exploreItem( Integer itemId){
        itemsTitles.get(itemId).click();
//        sleep(3000);

    }

    @Step("Check if products are properly filtered by price range")
    public void checkPriceRange(String minPrice, String maxPrice) {
        float floatMinPrice = Float.parseFloat(minPrice);
        float floatMaxPrice = Float.parseFloat(maxPrice);
        goForPriceRange.click();
//        sleep(2000);

        for (SelenideElement itemsPrice : itemsPrices) {
            boolean checkRange = false;
            SelenideElement itemFullPrice = itemsPrice.find(".a-price-whole");
            SelenideElement salePrice = itemsPrice.find(byXpath(".//span[@data-a-color='secondary']"));
            if (salePrice.exists() && checkRange == false && salePrice.getText().length() > 0) {
                float finalSalePrice = Float.parseFloat(salePrice.getText().replaceAll("\\$", "").trim());
                if (finalSalePrice >= floatMinPrice && finalSalePrice <= floatMaxPrice) {
                    checkRange = true;
                }
            }
            if (itemFullPrice.exists() && checkRange == false && itemFullPrice.getText().length() > 0) {
                float floatItemFullPrice = Float.parseFloat(itemFullPrice.getText());
                if (floatItemFullPrice >= floatMinPrice && floatItemFullPrice <= floatMaxPrice) {
                    checkRange = true;
                }
            }
            softAssert.assertTrue(checkRange);
        }

    }

    @Step("Check if similar products are displayed after clicking on cart button")
    public void cartButtonExists(){
        if(additionalDivforCart.exists()){
            goToCartOnAdditionalDiv.click();
        } else{
            goTocartWithoutDiv.click();
        }
    }
}

