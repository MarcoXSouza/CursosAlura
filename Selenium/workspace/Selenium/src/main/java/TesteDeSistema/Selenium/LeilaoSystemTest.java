package TesteDeSistema.Selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class LeilaoSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\marcos.souza\\Documents\\Marcos\\"
    			+ "Java\\Selenium\\downloads\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Tony Ramos", "tony@ramos.com");
	}
	@Test
	public void deveCadastrarumLeilao(){
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Gilete", 200, "Tony Ramos", true);
		
		assertTrue(leiloes.existe("Gilete", 200, "Tony Ramos", true));
	}	
}
