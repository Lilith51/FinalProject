package Utils;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {
    @BeforeTest
    @Description("Configures website")
    public void SetUp() {
        open("https://www.amazon.com/");
        Configuration.browserSize = "1920x1080";

    }
}
