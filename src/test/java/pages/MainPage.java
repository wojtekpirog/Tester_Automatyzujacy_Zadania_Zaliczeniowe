package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
  private static final Logger log = Logger.getLogger(MainPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//a/span[text()='Sign in']")
  private WebElement signInAnchor;
  @FindBy(xpath = "//a[text()='Hummingbird printed sweater']")
  private WebElement productSelectionAnchor;

  public MainPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method to go to login page:
  public void goToLoginPage() {
    try {
      signInAnchor.click();
      log.info("ℹ️User has been directed to the login page.ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Failed to find an element \"signInAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      throw e;
    }
  }
  //Method to go to PDP (Product Details Page):
  public void openProductDetailsPage() {
    try {
      productSelectionAnchor.click();
      log.info("ℹ️Product Details Page has been opened.ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Failed to find an element \"productSelectionAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
