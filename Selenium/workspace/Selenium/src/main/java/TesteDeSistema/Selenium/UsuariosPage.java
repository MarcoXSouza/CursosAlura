package TesteDeSistema.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {
	
	private WebDriver driver;
	
	public  UsuariosPage(WebDriver driver){	
		this.driver = driver;
	}
	
	public void visita() {
		driver.get("http://localhost:8080/usuarios");
	}

	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
	return new NovoUsuarioPage(driver);
	}
	
	public AlteraUsuariosPage altera(int posicao){	
		driver.findElements(By.linkText("editar")).get(posicao - 1).click();
		
		return new AlteraUsuariosPage(driver);
		
	}
	
	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && 
				driver.getPageSource().contains(email);
	}
	
}
