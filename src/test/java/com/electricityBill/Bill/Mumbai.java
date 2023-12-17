package com.electricityBill.Bill;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Random;import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Mumbai {
	public static WebDriver  driver;
	public  static WebDriverWait wait;
	public static String extractedText;
	
	public static void main(String[] args) throws IOException {
		int a=11;
		 String location="C:\\Users\\Innodeed Systems\\Documents\\DownloadfromAuto";
		 HashMap preferences2 = new HashMap();
    	 preferences2.put("download.default_directory", location);
		
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Start-maximized");
	//	 options.setExperimentalOption("prefs", preferences2);
//		options.addArguments("--Incognito");
		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
//		options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://wss.mahadiscom.in/wss/wss?uiActionName=getHome&Lang=English");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a//span[text()='View/Pay Bill']"))).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consumerNo"))).sendKeys("170003463225");
		
		  Random random = new Random();
		  int randomNumber = random.nextInt(); 
	   //     System.out.println("Random Number: " + randomNumber);
	        
		        WebElement section=driver.findElement(By.xpath("//canvas[@id='captcha']"));
		        File src=  section.getScreenshotAs(OutputType.FILE);
				  File  dest= new File("./screenshot/"+randomNumber+"CaptchaCode.jpg");
			      FileUtils.copyFile(src, dest);
			      

			        // Specify the path to the Tesseract executable
			        ITesseract tesseract = new Tesseract();
			        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

			        try {
			            // Use Tesseract to extract text from the screenshot
			           extractedText = tesseract.doOCR(ImageIO.read(src));

			            // Print the extracted text
			            System.out.println("Extracted Text: \n" + extractedText);
			        } catch (TesseractException | IOException e) {
			            e.printStackTrace();
			        } finally {
			            // Close the browser
			      //      driver.quit();
			        }
			      
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtInput']"))).sendKeys(extractedText);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitButton']"))).click();
			      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td//img[@onclick='popUpPrintBillHTML(this);']"))).click();
//
					Pdf pdf=	((PrintsPage) driver).print(new PrintOptions());
					Files.write(Paths.get("C:\\Users\\Innodeed Systems\\eclipse-workspace\\Bill\\ResoucesPdf"+randomNumber+".pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
			        System.out.println("Web page converted to PDF successfully.");
//			      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body"))).sendKeys(Keys.CONTROL, "p");
//			        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
			        // Wait for some time to allow the PDF to be generated
			        try {
			            Thread.sleep(5000); 
			            System.out.println("document saved succesfully");
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
			      
			    
		

	
		

	}
	 

}
