package BBC.pageObject;

import BBC.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(){
        driver = BrowserFactory.getDriver();
        PageFactory.initElements(driver,this);
    }

}
