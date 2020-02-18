package TesteDeSistema.Selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	private FirefoxDriver driver;
	private UsuariosPage usuarios;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\marcos.souza\\Documents\\Marcos\\"
    			+ "Java\\Selenium\\downloads\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.usuarios = new UsuariosPage(driver);
		usuarios.visita();
	}
	
//	@Test
//	public void deveAdicionarUmUsuario() {
//		
//		usuarios.visita();
//        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
//
//        assertTrue(usuarios.existeNaListagem(
//                "Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
//
//	}
	
	@Test
    public void deveAlterarUmUsuario() {

        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
    usuarios.altera(1).para("José da Silva", "jose@silva.com");

        assertFalse(usuarios.existeNaListagem(
                "Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
        assertTrue(usuarios.existeNaListagem("José da Silva", "jose@silva.com"));
	}
	
	@After
	public void encerra(){
		driver.close();
	}
	

}
