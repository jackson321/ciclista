import static org.junit.Assert.*;

import org.junit.Test;

import Ciclista.Ciclista;
import Ciclista.CiclistaException;


public class CiclistaTest {

	@Test
	public void deveCalcularVelocidadeMediaParaPercuso10KMPor1Hora() throws Exception {
		double velocidadeMedia = Ciclista.calcularVelocidadeMedia(10.0, 1.0);
		assertEquals(10.0, velocidadeMedia, 0);
	}

	@Test
	public void deveCalcularVelocidadeMediaParaPercurso20KMPor1hora() throws Exception {
		double velocidadeMedia = Ciclista.calcularVelocidadeMedia(20.0, 1.0);
		assertEquals(20.0, velocidadeMedia, 0);
	}
	
	@Test
	public void deveCalcularVelocidadeMediaParaPercurso40KMPor4horas() throws Exception {
		double velocidadeMedia = Ciclista.calcularVelocidadeMedia(40.0, 4.0);
		assertEquals(10.0, velocidadeMedia, 0);
	}

	@Test
	public void deveCalcularVelocidadeMediaParaPercurso50KMPor2horasEMeia() throws Exception {
		double velocidadeMedia = Ciclista.calcularVelocidadeMedia(50.0, 2.5);
		assertEquals(20.0, velocidadeMedia, 0);
	}

	@Test
	public void deveCalcularVelocidadeMediaParaPercurso100KMPor2horasEMeia() throws Exception {
		double velocidadeMedia = Ciclista.calcularVelocidadeMedia(100.0, 2.5);
		assertEquals(40.0, velocidadeMedia, 0);
	}
	
	@Test(expected = CiclistaException.class)
	public void naoDeveCalcularVelocidadeMediaParaPercursoDe0Horas() throws Exception {
		Ciclista.calcularVelocidadeMedia(50.0, 0.0);
	}
	
	@Test
	public void deveInterpretarValoresDeVelocidadeTempoParaDistancia10Tempo1() {
		double[] velocidadeTempo = Ciclista.interpretarValoresDeVelocidadeTempo("10.0 1.0");
		assertArrayEquals(new double[] {10.0, 1.0}, velocidadeTempo, 0);
	}
	
	@Test
	public void deveInterpretarValoresDeVelocidadeTempoParaDistancia20Tempo2() {
		double[] velocidadeTempo = Ciclista.interpretarValoresDeVelocidadeTempo("20.0 2.0");
		assertArrayEquals(new double[] {20.0, 2.0}, velocidadeTempo, 0);
	}
	
	@Test
	public void deveInterpretarValoresDeVelocidadeTempoParaDistancia40Tempo20() {
		double[] velocidadeTempo = Ciclista.interpretarValoresDeVelocidadeTempo("40.0 20.0");
		assertArrayEquals(new double[] {40.0, 20.0}, velocidadeTempo, 0);
	}
	
	@Test
	public void deveInterpretarValoresDeVelocidadeTempoParaDistancia50Tempo30() {
		double[] velocidadeTempo = Ciclista.interpretarValoresDeVelocidadeTempo("50.0 30.0");
		assertArrayEquals(new double[] {50.0, 30.0}, velocidadeTempo, 0);
	}
	
	@Test
	public void deveInterpretarValoresDeVelocidadeTempoParaDistancia100Tempo20() {
		double[] velocidadeTempo = Ciclista.interpretarValoresDeVelocidadeTempo("100.0 20.0");
		assertArrayEquals(new double[] {100.0, 20.0}, velocidadeTempo, 0);
	}
	
	@Test
	public void deveInterpretarValoresDeVelocidadeTempoParaDistancia100Tempo0() {
		double[] velocidadeTempo = Ciclista.interpretarValoresDeVelocidadeTempo("100.0 0.0");
		assertArrayEquals(new double[] {100.0, 0.0}, velocidadeTempo, 0);
	}

	@Test
	public void deveConverterDistanciaDeKilometrosParaMetros() {
		double distancia = Ciclista.converterDistanciaDeKilometrosParaMetros(1.0);
		assertEquals(1000, distancia, 0);
	}
	
	@Test
	public void deveConverterDistanciaDeMetrosParaKilometros() {
		double distancia = Ciclista.converterDistanciaDeMetrosParaKilometros(1000);
		assertEquals(1, distancia, 0);
	}

	@Test
	public void deveConverterTempoDeHorasParaMinutos() {
		double tempo = Ciclista.converterTempoDeHorasParaMinutos(1.0);
		assertEquals(60, tempo, 0);
	}
	
	@Test
	public void deveConverterTempoDe60MinutosPara1Hora() {
		double tempo = Ciclista.converterTempoDeMinutosParaHoras(60.0);
		assertEquals(1, tempo, 0);
	}

	@Test
	public void deveConverterTempoDe90MinutosPara1HoraEMeia() {
		double tempo = Ciclista.converterTempoDeMinutosParaHoras(90.0);
		assertEquals(1.5, tempo, 0);
	}
	
	@Test
	public void deveConverterDistanciaEmMetrosParaPadrao() {
		double distancia = Ciclista.converterDistanciaParaPadrao(1000.0, "metros");
		assertEquals(1, distancia, 0);
	}
	
	@Test
	public void deveConverterDistanciaEmKilometrosParaPadrao() {
		double distancia = Ciclista.converterDistanciaParaPadrao(1.0, "kilometros");
		assertEquals(1.0, distancia, 0);
	}

	
	@Test
	public void deveConverterTempoEmMinutosParaPadrao() {
		double tempo = Ciclista.converterTempoParaPadrao(60, "minutos");
		assertEquals(1, tempo, 0);
	}
	
	
	@Test
	public void deveConverterTempoEmHorasParaPadrao() {
		double tempo = Ciclista.converterTempoParaPadrao(1, "horas");
		assertEquals(1, tempo, 0);
	}
	
	@Test
	public void deveConverterTempoEmSegundosParaPadrao() {
		double tempo = Ciclista.converterTempoParaPadrao(3600, "segundos");
		assertEquals(1, tempo, 0);
	}
	
}


