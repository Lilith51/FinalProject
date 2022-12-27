package Amazon;
import AmazonStepObject.StepObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;
public class LanguageCheckRTL extends StepObject {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void languageChecker() {
        languagePicker.hover();
        languageList.get(1).click();
        softAssert.assertTrue($("html").getAttribute("dir").equalsIgnoreCase("rtl"));
        sleep(2000);
        languagePicker.hover();
        languageList.get(0).click();
        sleep(2000);
    }


}
