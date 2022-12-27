package AmazonDataObject;
import Utils.ChromeRunner;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardVariables extends ChromeRunner {
    public SelenideElement hamMenu = $("#nav-hamburger-menu");
    public SelenideElement mainDiv = $(byXpath("//ul[@data-menu-id='1']"));
    public ElementsCollection mainItems = mainDiv.findAll(byXpath(".//li/a[contains(@class,'hmenu-item')]"));

    // public ElementsCollection seeAllItems = mainDiv.findAll(byText("see all"));
    public SelenideElement innerDiv = $(byXpath(".//ul[contains(@class,'hmenu-visible')]"));
    public ElementsCollection innerDivItems = innerDiv.findAll(byTagName("li"));

    // public ElementsCollection seeAllDiv = mainDiv.findAll(byXpath(".//ul[@class='hmenu-compress-section']"));
    public SelenideElement minPrice = $("#low-price");
    public SelenideElement maxPrice = $("#high-price");
    public SelenideElement centralDiv = $(byXpath("//div[contains(@class,'s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16')]"));
    public SelenideElement goForPriceRange = $(byXpath("//div[@id='s-refinements']//span[@class='a-button-inner']/input[@type='submit']"));
    public ElementsCollection itemsPrices = centralDiv.findAll(byXpath(".//div[contains(@class,'a-color-base')]"));
    public ElementsCollection brands = $$(byXpath("//div[@id='brandsRefinements']/ul/li/span/a"));
    public ElementsCollection brandsCheckboxes = $$(byXpath("//div[@id='brandsRefinements']/ul/li/span/a/div/label/input"));
    public ElementsCollection itemsTitles = centralDiv.findAll(byXpath(".//div[@data-component-type='s-search-result']//span[contains(@class,'a-text-normal')]"));
    public SelenideElement addToCart = $(byXpath("//div[@id='exports-buybox-disabled-atc']//span[@id='exportsUndeliverable-cart']//input"));
    public SelenideElement addToCartError = $(byXpath("//div[@id='mir-layout-DELIVERY_BLOCK']//span[@class='a-color-error']"));
    public SelenideElement activeAddToCart = $("#add-to-cart-button");
    public SelenideElement additionalDivforCart = $(byXpath("//div[contains(@class, 'attach-accessory-section')]"));

    // public SelenideElement xButtonForAdditionalDiv = $("#attach-close_sideSheet-link");
    public SelenideElement goToCartOnAdditionalDiv  = $(byXpath("//span[@id='attach-sidesheet-view-cart-button']//input"));
    public SelenideElement goTocartWithoutDiv = $(byXpath("//span[@id='sw-gtc']//a"));
    public SelenideElement itemsQuantittyInCart = $(byXpath("//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt']"));
    public SelenideElement cartItemsQuantityInHeader = $("#nav-cart-count");
    public SelenideElement languagePicker = $("#icp-nav-flyout");
    public ElementsCollection languageList = $$(byXpath("//div[@id='nav-flyout-icp']//a[contains(@class,'nav-link')]"));
}
