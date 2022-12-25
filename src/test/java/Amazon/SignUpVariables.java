package Amazon;

import Utils.ChromeRunner;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SignUpVariables extends ChromeRunner {
    SelenideElement mainAccountListButton = $("#nav-link-accountList");
    SelenideElement accountListHover = $("#nav-al-signin");
    SelenideElement signUpButton = $(byXpath("//div[@id='nav-flyout-ya-newCust']//a"));
    SelenideElement signUpTitle = $(byXpath("//div[@class='a-box-inner']/h1"));
    ElementsCollection signUpInputList = $$(byXpath("//div[@class='a-box-inner']//input"));
    ElementsCollection errorMessages = $$(byXpath("//div[@class='a-box-inner a-alert-container']//div[@class='a-alert-content']"));
    SelenideElement continueButton = $("#continue");
    SelenideElement amazonMainLogo = $(byXpath("//a[@class='a-link-nav-icon']"));

}
