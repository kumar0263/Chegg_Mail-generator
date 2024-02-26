package com.chegg.automation;

import java.util.List;
import java.util.NoSuchElementException;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.IFactoryAnnotation;

public class Chegg_Automation_bHAGYA {

	public static void main(String[] args) throws InterruptedException, EmailException {
			// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			driver.get("https://expert.chegg.com/qna/authoring/answer");
			Thread.sleep(5000);
			driver.manage().window().maximize();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ghantasalabhagyasri@gmail.com");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kumar0263@B");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			String textele = "";
			boolean flag = true;
			while(flag){
				
				Thread.sleep(5000);
				List<WebElement> elements = driver.findElements(By.xpath("//h4[contains(text(),'Dear Expert!')]"));
				//WebElement element = driver.findElement(By.xpath("//h4[contains(text( ),'Dear Expert!')]"));
				if(!elements.isEmpty()){
					 Thread.sleep(60000);
		             driver.navigate().refresh();
				}else {
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.get("https://expert.chegg.com/qna/authoring/answer");
					Thread.sleep(3000);
					List<WebElement> elementsagain = driver.findElements(By.xpath("//h4[contains(text(),'Dear Expert!')]"));
					if(elementsagain.isEmpty()) {
						flag = false;
						
						System.out.println("You got a question check email");
						try {
							 EmailSender.sendEmail();
			                } catch (MessagingException e) {
			                    System.out.println("Failed to send email: " + e.getMessage());
			                }
						break;
					}
					
				}
				
//				if(textele.equalsIgnoreCase("Dear Expert!")) {
//		                Thread.sleep(60000);
//		                driver.navigate().refresh();
//				}else {
//					flag = false;
//					try {
//						 EmailSender.sendEmail();
//		                } catch (MessagingException e) {
//		                    System.out.println("Failed to send email: " + e.getMessage());
//		                }
//					break;
//				}
			}
		

	}
}
