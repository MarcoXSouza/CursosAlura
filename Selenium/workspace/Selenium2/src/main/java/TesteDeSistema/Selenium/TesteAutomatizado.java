package TesteDeSistema.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
       
		System.setProperty("webdriver.chrome.driver","C:\\Users\\marcos.souza\\Documents"
				+ "\\Marcos\\Java\\Selenium\\downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com.br/");

        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Caelum");

        campoDeTexto.submit();

    }
}