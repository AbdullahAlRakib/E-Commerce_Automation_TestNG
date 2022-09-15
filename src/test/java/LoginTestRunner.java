import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils;
    @Test(priority = 2)
    public void doLoginWithValidCreds() throws IOException, ParseException, org.json.simple.parser.ParseException {
        loginPage=new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(utils.getUserCount());
       // driver.get("http://automationpractice.com/");
        boolean isLogoutFound=loginPage.doLoginWithValidCreds(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(isLogoutFound,true);
        //loginPage.linkLogout.click();
    }
    @Test(priority = 1)
    //for wrong pass
    public void doLoginWithInvalidPass() throws IOException, ParseException, org.json.simple.parser.ParseException {
        driver.get("http://automationpractice.com/");
        loginPage=new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(1);
        String validationMessage=loginPage.doLoginWithInvalidPass(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("failed"));
    }
}
