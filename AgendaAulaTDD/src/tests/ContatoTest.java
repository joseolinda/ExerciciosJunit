package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import javax.management.InvalidAttributeValueException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Contato;

public class ContatoTest {

	private Contato contatoTeste;

	/** * Initialization */
	@BeforeEach
	void setUp() throws Exception {
		contatoTeste = new Contato();
	}
	
	/** * Section of Contato's methods tests */
	@Test
	@DisplayName("Definir e retornar Nome")
	public void testAgendaSetGetNome() {
		contatoTeste.setNome("José");
		assertEquals("José", contatoTeste.getNome());
	}
	
	@Test
	@DisplayName("Definir e retornar Idade")
	public void testAgendaSetGetIdade() {
		contatoTeste.setIdade(25);
		assertEquals(25, contatoTeste.getIdade());
	}
	
	@Test
	@DisplayName("Definir e retornar Telefone")
	public void testAgendaSetGetTelefone() {
		try {
			contatoTeste.setTelefone("889910101515");
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("889910101515", contatoTeste.getTelefone());
	}
	
	@Test
	@DisplayName("Impedir inserir telefone com tamanho menor que 11 dígitos")
	public void testContatoMenorQue11() {
		contatoTeste.setNome("jose");
		assertThrows(InvalidAttributeValueException.class, () ->{
			contatoTeste.setTelefone("123");
			contatoTeste.setTelefone("1234567890");
		});
	}
	
	@Test
	@DisplayName("Impedir inserir idade negativa")
	public void testContatoIdadeNegativa() {
		contatoTeste.setNome("jose");
		int esperado = contatoTeste.getIdade();
		contatoTeste.setIdade(-2);
		assertEquals(esperado, contatoTeste.getIdade());;
	}
	
	@Test
	@DisplayName("Impedir inserir nome vazio")
	public void testContatoNomeVazio() {
		assertFalse(contatoTeste.setNome(""));
	}

	/** * Destroy  the object */
	@AfterEach
	void tearDown() throws Exception {
		contatoTeste = null;
	}

}
