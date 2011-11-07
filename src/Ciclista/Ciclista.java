package Ciclista;


import java.util.Scanner;

public class Ciclista {

	public static void main(String [] args) throws CiclistaException {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("Informe distancia e tempo: ");
			String valoresEntrada = scanner.nextLine();
			double[] velocidadeTempo = interpretarValoresDeVelocidadeTempo(valoresEntrada);
			
			System.out.print("Informe unidade de distancia ");
			String unidadeDistancia = scanner.nextLine();

			System.out.print("Informe unidade de tempo ");
			String unidadeTempo = scanner.nextLine();
			
			double distanciaPadrao = converterDistanciaParaPadrao(velocidadeTempo[0], unidadeDistancia);
			double tempoPadrao = converterTempoParaPadrao(velocidadeTempo[1], unidadeTempo);
			
			double velocidadeMedia = calcularVelocidadeMedia(distanciaPadrao, tempoPadrao);
			System.out.println("Velocidade media nas unidades padrao: " + velocidadeMedia + " km/h");
			
			
		}
	}
	
	public static double calcularVelocidadeMedia(double distancia, double tempo) throws CiclistaException {
		if(tempo == 0.0) {
			throw new CiclistaException();
		}
		return (distancia/tempo);
	}

	public static double[] interpretarValoresDeVelocidadeTempo(String valoresEntrada) {
		String[] velocidadeTempoString = valoresEntrada.split(" ");
		return new double[] {Double.parseDouble(velocidadeTempoString[0]), Double.parseDouble(velocidadeTempoString[1])};
	}
	

	public static double converterDistanciaDeKilometrosParaMetros(double distanciaKm) {
		
		
		
		return distanciaKm * 1000;
	}

	public static double converterDistanciaDeMetrosParaKilometros(double distanciaMetros) {
	
		return distanciaMetros / 1000;
	}

	public static double converterTempoDeHorasParaMinutos(double tempoHora) {
		
		return tempoHora * 60;
	}

	public static double converterTempoDeMinutosParaHoras(double tempoMinutos) {
		
		return tempoMinutos / 60;
	}

	public static double converterDistanciaParaPadrao(double distancia, String unidadeDistancia) {
		double distanciaPadrao = 0;
		
		if("metros".equals(unidadeDistancia)) {
			distanciaPadrao = converterDistanciaDeMetrosParaKilometros(distancia);
		}
		if("kilometros".equals(unidadeDistancia)) {
			distanciaPadrao = distancia;
		}
		return distanciaPadrao;
	}

	public static double converterTempoParaPadrao(double tempo, String unidadeTempo) {
		double tempoPadrao = 0;
		
		if("minutos".equals(unidadeTempo)) {
			tempoPadrao = converterTempoDeMinutosParaHoras(tempo);
		}
		if("horas".equals(unidadeTempo)) {
			tempoPadrao = tempo;
		}
		if("segundos".equals(unidadeTempo)){
			tempoPadrao = converterTempoDeSegundosParaHoras(tempo);
		}
		
		return tempoPadrao;
	}

	private static double converterTempoDeSegundosParaHoras(double tempo) {
		return tempo / 3600;
	}
}
