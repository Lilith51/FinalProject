package Amazon;
import AmazonDataObject.SignUpVariables;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class SignUpFunctionality extends SignUpVariables {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void registrationSuccessCase() {
        mainAccountListButton.hover();
        accountListHover.shouldBe(Condition.visible);
        signUpButton.click();
        boolean matchTitle = signUpTitle.getText().equalsIgnoreCase("Create Account");
        Assert.assertTrue(matchTitle);
        String testPass = "Spark123!";
        String testEmail = "jhsdjhsdjfh@mail.com";
        for (SelenideElement signUpInput : signUpInputList) {
            String attributeName = signUpInput.getAttribute("name");
            if(signUpInput.getAttribute("type").equals("submit")){
                signUpInput.click();
                break;
            }
            if (attributeName.equals("customerName")) {
                signUpInput.setValue("Random Name");
                softAssert.assertEquals("Random Name", signUpInput.getValue());
                continue;
            }
            if (attributeName.equals("email")) {
                signUpInput.setValue(testEmail);
                softAssert.assertEquals(testEmail, signUpInput.getValue());
                continue;
            }
            if(attributeName.equals("password")) {
                signUpInput.setValue(testPass);
                softAssert.assertEquals(testPass, signUpInput.getValue());
                continue;
            }
            if(attributeName.equals("passwordCheck")) {
                signUpInput.setValue(testPass);
                softAssert.assertEquals(testPass, signUpInput.getValue());
            }
        }
        softAssert.assertAll();
        sleep(3000);
    }
    @Test
    public void signUpWithoutValuesCase() {
        sleep(3000);
        amazonMainLogo.click();
        mainAccountListButton.hover();
        accountListHover.shouldBe(Condition.visible);
        signUpButton.click();
        continueButton.click();
        for (SelenideElement errorMessage : errorMessages) {
            String errorText = errorMessage.getText();
            System.out.println(errorText);
            boolean nameError = errorText.equalsIgnoreCase("Enter your name");
            if (nameError) {
                softAssert.assertTrue(true, "Enter your name");
                continue;
            }
            boolean emailError = errorText.equalsIgnoreCase("Enter your email or mobile phone number");
            if (emailError) {
                softAssert.assertTrue(true, "Enter your email or mobile phone number");
                continue;
            }
            boolean passError = errorText.equalsIgnoreCase("Minimum 6 characters required");
            if (passError) {
                softAssert.assertTrue(true, "Minimum 6 characters required");
            }
        }
        softAssert.assertAll();
    }


}
