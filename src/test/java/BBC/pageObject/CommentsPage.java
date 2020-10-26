package BBC.pageObject;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommentsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    WebElement signInTab;
    @FindBy(xpath = "//input[@id='user-identifier-input']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@id='password-input']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@id='submit-button']")
    WebElement submitBtn;
    @FindBy(xpath = "//h2[contains(text(),'News headlines')]")
    WebElement newsHeadlines;

    public void signInTab() {
        signInTab.click();
    }

    static String decodeUsr(String usr) {
        byte[] decodedString = Base64.decodeBase64(usr);
        return (new String(decodedString));
    }
    static String decodeString(String pwd) {
        byte[] decodedString = Base64.decodeBase64(pwd);
        return (new String(decodedString));
    }

    public void userLogIn(String username, String password) {
        userNameField.sendKeys(decodeUsr(username));
        passwordField.sendKeys(decodeString(password));
        submitBtn.click();

    }
    /**
     * Click on News Headlines
     */
    public void newsHeadlines() {
        newsHeadlines.click();
    }

    /**
     * Verify BBC home page
     */
    public void verifyTitleText() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "BBC - Home");

    }
    /**
     * Find article where commenting is enabled.
     */
    public void goOnEnabledArticle() {
        List<WebElement> refList = driver.findElements(By.className("gs-c-comment-count"));

        if (refList.size() > 0) {
            refList.get(0).click();
        } else {
            System.out.println("Commenting Not Enable");

        }
    }

    /**
     * Checks box for all comments displayed
     */
    public void verifyViewCommentsBody() {
        driver.switchTo().frame(driver.findElement(By.className("css-oxwlos-StylediFrame")));
        WebElement viewCommentsBlock = driver.findElement(By.className("comments__body"));
        Assert.assertTrue(viewCommentsBlock.isDisplayed());
        driver.switchTo().defaultContent();
    }

    /**
     * Checks text box to enter comment by signed in user displayed
     */
    public void verifyInputCommentBox() {
        driver.switchTo().frame(driver.findElement(By.className("css-oxwlos-StylediFrame")));
        WebElement addCommentBox = driver.findElement(By.className("comments__input-area"));
        Assert.assertTrue(addCommentBox.isDisplayed());
        driver.switchTo().defaultContent();
    }

    /**
     * Checks "Sign in and Register" button displayed
     */
    public void signInButtonVisible() {
        driver.switchTo().frame(driver.findElement(By.className("css-oxwlos-StylediFrame")));

        //Sign in button
        WebElement signInBtn = driver.findElement(By.className("id4-cta-signin"));
        Assert.assertTrue(signInBtn.isDisplayed());

        //Register Button
        WebElement registerBtn = driver.findElement(By.className("id4-cta-register"));
        Assert.assertTrue(registerBtn.isDisplayed());

        driver.switchTo().defaultContent();
    }


}
