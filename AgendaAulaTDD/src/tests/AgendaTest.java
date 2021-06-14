package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.Agenda;
import main.Contato;

@TestMethodOrder(OrderAnnotation.class)
public class AgendaTest {
	
	private Agenda agendaTeste;
	
	// Criar lista de contatos
	void fillAgenda(int total) {
		for(int i = 0; i < total; i++) {
			Contato novoContato = new Contato();
			
			novoContato.setNome("Adriana " + i);
			novoContato.setIdade(50);
			novoContato.setTelefone("885544332" + i);
			
			agendaTeste.addContact(novoContato);
		}		
	}

	@BeforeEach
	void setUp() throws Exception {
		agendaTeste = new Agenda();
	}

	@AfterEach
	void tearDown() throws Exception {
		agendaTeste = null;
	}

	@Test
	@DisplayName("Adicionar contato")
	@Order(1) 
	void testAgendaAdicionarContato() {
		Contato novoContato = new Contato();
		
		novoContato.setNome("Adriana");;
		novoContato.setIdade(50);
		novoContato.setTelefone("885544332215");
		
		assertTrue(agendaTeste.addContact(novoContato));
	}
	
	@Test
	@DisplayName("Impedir adicionar mais de 10 contatos")
	@Order(2) 
	void testAgendaLimiteAdicionarContato() {
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.fillAgenda(11);
		});		
	}
	
	@Test
	@DisplayName("Impedir adicionar contato com mesmo numero")
	@Order(3) 
	void testAgendaAdicionarContatoDuplicado() {
		
		Contato novoContato1 = new Contato();
			
		novoContato1.setNome("Maria");
		novoContato1.setIdade(25);
		novoContato1.setTelefone("885533321527");
		
		agendaTeste.addContact(novoContato1);
		
		Contato novoContato2 = new Contato();
		
		novoContato2.setNome("Mariana");
		novoContato2.setIdade(28);
		novoContato2.setTelefone("885533321527");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agendaTeste.addContact(novoContato2);
		});
	}
	
	@Test
	@DisplayName("Remover contato")
	@Order(4) 
	void testAgendaRemoverContato() {
		Contato contatoTeste = new Contato();
		
		contatoTeste.setNome("Daniel");;
		contatoTeste.setIdade(13);
		contatoTeste.setTelefone("889944662215");
		
		agendaTeste.addContact(contatoTeste);
		
		assertTrue(agendaTeste.removeContact(contatoTeste));		
	}
	
	@Test
	@DisplayName("Buscar Contato Pelo Nome")
	@Order(5) 
	void testAgendaBuscarContatoPeloNome() {
		Contato contatoTeste = new Contato();
		
		contatoTeste.setNome("Ana");;
		contatoTeste.setIdade(13);
		contatoTeste.setTelefone("999999999999");
		
		agendaTeste.addContact(contatoTeste);
		
		assertEquals(Contato.class, agendaTeste.findContactByName("Ana").getClass());
	}
	
	@Test
	@DisplayName("Imprimir todos os contato")
	@Order(7) 
	void testAgendaImprimirTodosOsConatos() {
		this.fillAgenda(8);
		
		assertTrue(agendaTeste.printAllContacts());
	}
	
	@Test
	@DisplayName("Imprimir contato por nome")
	@Order(6) 
	void testAgendaImprimirContatoPorNome() {
		this.fillAgenda(5);
		
		assertTrue(agendaTeste.printContact("Adriana 3"));
	}

}
