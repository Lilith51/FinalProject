package Amazon;
import Utils.ChromeRunner;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardVariables extends ChromeRunner {
    SelenideElement hamMenu = $("#nav-hamburger-menu");
    public SelenideElement mainDiv = $(byXpath("//ul[@data-menu-id='1']"));
    ElementsCollection mainItems = mainDiv.findAll(byXpath(".//li/a[contains(@class,'hmenu-item')]"));

    ElementsCollection seeAllItems = mainDiv.findAll(byText("see all"));
    public SelenideElement innerDiv = $(byXpath(".//ul[contains(@class,'hmenu-visible')]"));
    ElementsCollection innerDivItems = innerDiv.findAll(byTagName("li"));

    ElementsCollection seeAllDiv = mainDiv.findAll(byXpath(".//ul[@class='hmenu-compress-section']"));
    SelenideElement minPrice = $("#low-price");
    SelenideElement maxPrice = $("#high-price");
    SelenideElement centralDiv = $(byXpath("//div[contains(@class,'s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16')]"));
    SelenideElement goForPriceRange = $(byXpath("//div[@id='s-refinements']//span[@class='a-button-inner']/input[@type='submit']"));
    ElementsCollection itemsPrices = centralDiv.findAll(byXpath(".//div[contains(@class,'a-color-base')]"));
    ElementsCollection brands = $$(byXpath("//div[@id='brandsRefinements']/ul/li/span/a"));
    ElementsCollection brandsCheckboxes = $$(byXpath("//div[@id='brandsRefinements']/ul/li/span/a/div/label/input"));
    ElementsCollection itemsTitles = centralDiv.findAll(byXpath(".//div[@data-component-type='s-search-result']//span[contains(@class,'a-text-normal')]"));
    SelenideElement addToCart = $(byXpath("//div[@id='exports-buybox-disabled-atc']//span[@id='exportsUndeliverable-cart']//input"));
    SelenideElement addToCartError = $(byXpath("//div[@id='mir-layout-DELIVERY_BLOCK']//span[@class='a-color-error']"));
    SelenideElement activeAddToCart = $("#add-to-cart-button");
    SelenideElement additionalDivforCart = $(byXpath("//div[contains(@class, 'attach-accessory-section')]"));

    SelenideElement xButtonForAdditionalDiv = $("#attach-close_sideSheet-link");
    SelenideElement goToCartOnAdditionalDiv  = $(byXpath("//span[@id='attach-sidesheet-view-cart-button']//input"));
    SelenideElement goTocartWithoutDiv = $(byXpath("//span[@id='sw-gtc']//a"));
    SelenideElement itemsQuantittyInCart = $(byXpath("//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt']"));
    SelenideElement cartItemsQuantityInHeader = $("#nav-cart-count");
    SelenideElement languagePicker = $("#icp-nav-flyout");
    ElementsCollection languageList = $$(byXpath("//div[@id='nav-flyout-icp']//a[contains(@class,'nav-link')]"));
}
