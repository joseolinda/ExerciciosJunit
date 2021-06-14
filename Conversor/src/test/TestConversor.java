package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Conversor;

class TestConversor {
	
	private Conversor meuConversor;

	@BeforeEach
	void setUp() throws Exception {
		meuConversor = new Conversor();
	}

	@AfterEach
	void tearDown() throws Exception {
		meuConversor = null;
	}

	@Test
	@DisplayName("Converter de Celcius para Kelvin")
	void testConversorCelsiusKelvin() {
		assertEquals(373.15, meuConversor.celsiusParaKelvin(100), 0.01);
		assertEquals(273.15, meuConversor.celsiusParaKelvin(0), 0.01);
		assertEquals(233.15, meuConversor.celsiusParaKelvin(-40), 0.01);
	}
	
	@Test
	@DisplayName("Converter de Kelvin para Celcius")
	void testConversorKelvinCelcius() {
		assertEquals(-173.15, meuConversor.kelvinParaCelcius(100), 0.01);
	}
	
	@Test
	@DisplayName("Converter de Celcius para Fahrenheit")
	void testConversorCelciusFahrenheit () {
		assertEquals(212, meuConversor.celciusParaFahrenheit(100), 0.01);
		assertEquals(32, meuConversor.celciusParaFahrenheit(0), 0.01);
		assertEquals(-40, meuConversor.celciusParaFahrenheit(-40), 0.01);
	}
	
	@Test
	@DisplayName("Converter de Fahrenheit para Celcius")
	void testConversorFahrenheitCelcius () {
		assertEquals(100, meuConversor.fahrenheitParaCelcius(212), 0.01);
		assertEquals(0, meuConversor.fahrenheitParaCelcius(32), 0.01);
		assertEquals(-40, meuConversor.fahrenheitParaCelcius(-40), 0.01);
	}
	
	@Test
	@DisplayName("Converter de Fahrenheit para Kelvin")
	void testConversorFahrenheitKelvin () {
		assertEquals(373.15, meuConversor.fahrenheitParaKelvin(212), 0.01);
		assertEquals(273.15, meuConversor.fahrenheitParaKelvin(32), 0.01);
		assertEquals(233.15, meuConversor.fahrenheitParaKelvin(-40), 0.01);
	}
	
	@Test
	@DisplayName("Converter de Kelvin para Fahrenheit")
	void testConversorKelvinFahrenheit () {
		assertEquals(212, meuConversor.kelvinParaFahrenheit(373.15), 0.01);
		assertEquals(32, meuConversor.kelvinParaFahrenheit(273.15), 0.01);
		assertEquals(-40, meuConversor.kelvinParaFahrenheit(233.15), 0.01);
	}

}
