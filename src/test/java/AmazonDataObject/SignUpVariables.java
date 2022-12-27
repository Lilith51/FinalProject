package AmazonDataObject;

import Utils.ChromeRunner;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SignUpVariables extends ChromeRunner {
    public SelenideElement mainAccountListButton = $("#nav-link-accountList");
    public SelenideElement accountListHover = $("#nav-al-signin");
    public SelenideElement signUpButton = $(byXpath("//div[@id='nav-flyout-ya-newCust']//a"));
    public SelenideElement signUpTitle = $(byXpath("//div[@class='a-box-inner']/h1"));
    public ElementsCollection signUpInputList = $$(byXpath("//div[@class='a-box-inner']//input"));
    public ElementsCollection errorMessages = $$(byXpath("//div[@class='a-box-inner a-alert-container']//div[@class='a-alert-content']"));
    public SelenideElement continueButton = $("#continue");
    public SelenideElement amazonMainLogo = $(byXpath("//a[@class='a-link-nav-icon']"));

}
