package org.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.page.MainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    private final Logger logger = LogManager.getLogger(MainPage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }
    public WebElement FindElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }
    public List<WebElement> FindElements(By by) {

        List<WebElement> list = new ArrayList<>();

        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            list = driver.findElements(by);

        } catch (Exception e) {

            System.out.println("Disabled item not exist.");

        }

        return list;
    }
    public void SendKeys(By by,String text){
        FindElement(by).sendKeys(text);
    }
    public void Click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        FindElement(by).click();
    }
    public void WaitPageLoad(String webURL) {
        WebDriverWait wait = new WebDriverWait(driver  , 1);
        wait.until(ExpectedConditions.urlToBe(webURL));
    }
    public void ClearText(By by) {
        FindElement(by).sendKeys(Keys.COMMAND + "a");
        FindElement(by).sendKeys(Keys.DELETE);
    }
    public void Wait(long timeToWait) throws InterruptedException {
        Thread.sleep(timeToWait);
    }
    public void SendEnter(By by){
        FindElement(by).sendKeys(Keys.ENTER);
    }
    public void FindCards(By by) throws IOException {
        List<WebElement> cards = FindElements(by);
        //System.out.println(cards.get(0).getText());
        cards.get(0).click();

    }
    public String ReadFromExcel(int productNo) throws Exception {

        String filePath = System.getProperty("user.dir") + "/Excel/search_data.xlsx";
        File src = new File(filePath);
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheetAt(0);
        return sheet.getRow(productNo).getCell(0).getStringCellValue();

    }
    public void WriteToFile(By name, By price){

        String dataName = FindElement(name).getText();
        String dataPrice = FindElement(price).getText();
        String filePath = System.getProperty("user.dir") + "/urunbilgi.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(dataName + "\n" + dataPrice);
            writer.close();
        } catch (IOException e) {

            logger.fatal("Error is " + e);
        }

    }
    public String GetFromTextFromFile() throws IOException {

        File file = new File("/Users/omermesebuken/Desktop/Selenium Projects/Beymen/urunbilgi.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String price;

        br.readLine();
        price = br.readLine();

        fr.close();

        return price;
    }
    public void CompareStrings(By by) throws IOException {

        String firstPrice = GetFromTextFromFile();

        String lastPrice = FindElement(by).getText();
        lastPrice = lastPrice.replace(",00", "");

        System.out.println("First Price: " + firstPrice);
        System.out.println("Last Price: " + lastPrice);

        Assert.assertEquals(firstPrice, lastPrice);
    }
    public void FindSizes(By all_Sizes,By disabled_Sizes)  {

        List<WebElement> allSizes = FindElements(all_Sizes);
        List<WebElement> disabledSizes = FindElements(disabled_Sizes);

        List<WebElement> activeSizes = new ArrayList<>();



        for (WebElement item: allSizes) {

            if(!disabledSizes.contains(item))
            {
                activeSizes.add(item);
            }
        }


        activeSizes.get(0).click();

    }
    public void IncreaseItemSizeAndCheck(By by) {
        Select se = new Select(FindElement(by));
        se.selectByValue("2");

        WebElement selectedOption = se.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(),"2 adet");
        System.out.println("Current item count is 2.");
    }
    public void DeleteItemFromBasketAndCheck(By by, By by2) throws InterruptedException {
        Click(by);
        Wait(500);
        Assert.assertEquals(FindElement(by2).getText(),"SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");
        System.out.println("Basket is empty.");
    }



}