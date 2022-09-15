import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    @FindBy(className = "login")
    WebElement linkLogin;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnSubmit;

    @FindBy(className = "logout")
    WebElement linkLogout;

    //for wrong pass
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement lblAuthError;

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }
    //test steps
    // public boolean deyar karon isDisplayed
    public Boolean doLoginWithValidCreds(String email,String password){
        linkLogin.click();
        txtEmail.sendKeys(email);//"salman@test.com"
        txtPassword.sendKeys(password);//"P@ssword123"
        btnSubmit.click();
        return linkLogout.isDisplayed();

    }
    //for wrong pass test case
    public String doLoginWithInvalidPass(String email,String password){
        linkLogin.click();
        txtEmail.sendKeys(email);//"salman@test.com"
        txtPassword.sendKeys(password);//"P@ssword123"
        btnSubmit.click();
        return lblAuthError.getText();

    }

}
