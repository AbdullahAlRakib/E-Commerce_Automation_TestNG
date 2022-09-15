import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTestRunner extends Setup {
    OrderPage orderPage;
    @Test(priority = 1)
    public void searchProduct(){
        driver.get("http://automationpractice.com/");
        orderPage=new OrderPage(driver);
        String res= orderPage.searchProduct("dress");
        Assert.assertTrue(res.contains("results have been found"));
        Allure.description("User can Search Product");
    }
    @Test(priority =2 )
    public void chooseProduct(){
        orderPage=new OrderPage(driver);
        boolean found=orderPage.chooseProduct();
        Assert.assertTrue(found);
        Allure.description("User can choose Product");

    }
    @Test(priority = 3)
    public void addToCart(){
        orderPage=new OrderPage(driver);
        boolean found=orderPage.addToCart();
        Assert.assertTrue(found);
        Allure.description("User can add to cart");

    }
    @Test(priority = 4)
    public void checkProductSummary(){
        orderPage=new OrderPage(driver);
      String summaryText=orderPage.checkProductSummary();
      Assert.assertTrue(summaryText.contains("SOPPING_CART SUMMARY"));
      Allure.description("User can View Product summary before checkout ");
    }
}
