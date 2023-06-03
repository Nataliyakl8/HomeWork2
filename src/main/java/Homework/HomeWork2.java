package Homework;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomeWork2 {

    @Test
    public void Test(){
        Assert.assertTrue(true);

    }

    @Test
    public  void TestCase1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");

        WebElement loginButton= driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        String actualTitle2= driver.getTitle();
        String expectedTitle2="Web Orders";
        Assert.assertEquals(actualTitle2,expectedTitle2);

        WebElement header= driver.findElement(By.tagName("h2"));

        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="List of All Orders";

        Assert.assertEquals(actualHeader,expectedHeader);

    }

    @Test
    public void TestCase2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");

        WebElement loginButton= driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        WebElement viewProducts=driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewProducts.click();
        Thread.sleep(2000);
        viewProducts=driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        Assert.assertTrue(viewProducts.isEnabled());

        WebElement header= driver.findElement(By.tagName("h2"));

        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("Products"));


    }

    @Test
    public void TestCase3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");

        WebElement loginButton= driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        WebElement allOrders=driver.findElement(By.linkText("View all orders"));
        String actualAllOrderHREF = allOrders.getAttribute("href");
        String expectedAllOrderHREF="Default.aspx";
        Assert.assertTrue(actualAllOrderHREF.contains(expectedAllOrderHREF));

        WebElement allProducts= driver.findElement(By.linkText("View all products"));
        String actualAllProductHREF= allProducts.getAttribute("href");
        String expectedAllProductHREF="Products.aspx" ;
        Assert.assertTrue(actualAllProductHREF.contains(expectedAllProductHREF));

        WebElement order= driver.findElement(By.linkText("Order"));
        String actualOrderHREF = order.getAttribute("href");
        String expectedOrderHREF="Process.aspx";
        Assert.assertTrue(actualOrderHREF.contains(expectedOrderHREF));

    }
    @Test
    public void TestCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");

        WebElement loginButton= driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        WebElement orderButton= driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();

        WebElement product= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));

        Select select= new Select(product);

        select.selectByValue("ScreenSaver");

        WebElement quantity= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");

        WebElement customerName= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");

        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");

        WebElement zipCode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60018");

        WebElement card= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();

        WebElement cardNumber= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");

        WebElement expirationDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");

        WebElement button= driver.findElement(By.cssSelector(".btn_light"));
        button.click();

        WebElement msg= driver.findElement(By.xpath("//strong[contains(text(),'New order has been')]"));

        Assert.assertTrue(msg.isDisplayed());

        WebElement viewAllOrders= driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();

        List<WebElement > orderAdded=driver.findElements(By.xpath("//div//table//tbody//tr[2]"));
        List<String> expectedOder= Arrays.asList("CodeFish IT School","ScreenSaver","5","06/03/2023","2200 E devon","Des Plaines",
                "Illinois","60018","MasterCard","444993876233","03/24");



        for (int i = 1; i < orderAdded.size(); i++) {
            Assert.assertEquals(orderAdded.get(i).getText(),expectedOder.get(i));
        }

/*
        WebElement name1=driver.findElement(By.xpath("//td[contains(text(),'CodeFish IT School')]"));
        String actualName1=BrowserUtils.getText(name1);

        WebElement product1=driver.findElement(By.xpath("//td[contains(text(),'ScreenSaver')]"));
        String actualP1=BrowserUtils.getText(product1);

        WebElement qty =driver.findElement(By.xpath("//td[.='5']"));
        String actualQty=BrowserUtils.getText(qty);

        WebElement date =driver.findElement(By.xpath("//td[.='06/03/2023']"));
        String actualDate=BrowserUtils.getText(date);

        WebElement street1 =driver.findElement(By.xpath("//td[.='2200 E devon']"));
        String actualStreet1=BrowserUtils.getText(street1);

        WebElement city1 =driver.findElement(By.xpath("//td[.='Des Plaines']"));
        String actualCity1=BrowserUtils.getText(city1);//td[.='Illinois']

        WebElement state1 =driver.findElement(By.xpath("//td[.='Illinois']"));
        String actualState1=BrowserUtils.getText(state1);

        WebElement zip =driver.findElement(By.xpath("//td[.='60018']"));
        String actualZip=BrowserUtils.getText(zip);

        WebElement cardType =driver.findElement(By.xpath("//td[contains(text(),'MasterCard')]"));
        String actualCardType=BrowserUtils.getText(cardType);

        WebElement cardNum =driver.findElement(By.xpath("//td[.='444993876233']"));
        String actualCardNum=BrowserUtils.getText(cardNum);

        WebElement cardExp =driver.findElement(By.xpath("//td[.='03/24']"));
        String actualCardExp=BrowserUtils.getText(cardExp);

        Thread.sleep(5000);



        Assert.assertTrue(actualName1.equals("CodeFish IT School")&& actualP1.equals("ScreenSaver")&&actualQty.equals("5")
                &&actualDate.equals("06/02/2023")
                && actualStreet1.equals("2200 E devon") && actualCity1.equals("Des Plaines")
                && actualState1.equals("Illinois") && actualZip.equals("60018") && actualCardType.equals("MasterCard")
                && actualCardNum.equals("444993876233")&& actualCardExp.equals("03/24"));



*/







    }
}
