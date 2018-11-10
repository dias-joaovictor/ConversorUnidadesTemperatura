package main;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.ValoresConversao;
import tipo.TipoConversao;

public class Main {

	private static final String VALOR_INVALIDO = "Valor inválido";
	private static final String TEXTO_VALOR_CONVERTER = "Digite o valor a ser convertido";

	public static void main(String[] args) {
//		List<ValoresConversao> lista = new ArrayList<>();
//
//		ValoresConversao valores1 = new ValoresConversao(12., TipoConversao.DE_CELSIUS_PARA_KELVIN);
//		ValoresConversao valores2 = new ValoresConversao(12., TipoConversao.DE_CELSIUS_PARA_FAHRENHEIT);
//		ValoresConversao valores3 = new ValoresConversao(12., TipoConversao.DE_CELSIUS_PARA_RANKINE);
//		ValoresConversao valores4 = new ValoresConversao(12., TipoConversao.DE_CELSIUS_PARA_REAUMUR);
//		lista.add(valores1);
//		lista.add(valores2);
//		lista.add(valores3);
//		lista.add(valores4);
//
//		lista.forEach(item -> System.out.println(item.obterTextoParaExibiao()));
		
		Main.doRun();

	}

	private static void doRun() {
		header();

		boolean sair = false;
		while (!sair) {
			body();
			try {
				List<ValoresConversao> lista = new ArrayList<>();
				int opcaoEscolhida = scannearOpcaoEConverterEmInteiro();
				imprimirTexto(TEXTO_VALOR_CONVERTER);
				if(opcaoEscolhida >= 0 && opcaoEscolhida <= 5 ) {
					if(opcaoEscolhida == 0) {
						sair = true;
					}else if (opcaoEscolhida < 5){
						lista.add(new ValoresConversao(scannearValorASerConvertidoEConverterEmDouble(), TipoConversao.fromValue(opcaoEscolhida)));
						sair = true;
					}else {
						Double valor = scannearValorASerConvertidoEConverterEmDouble();
						for (TipoConversao item : TipoConversao.values()) {
							lista.add(new ValoresConversao(valor, item));
						}
						sair = true;
					}
					
					lista.forEach(item -> System.out.println(item.obterTextoParaExibiao()));
				}
			} catch (NumberFormatException e) {
				
				imprimirTexto(VALOR_INVALIDO);
			}

		}

	}

	private static void imprimirTexto(String ...texto) {
		for (String valor : texto) {
			System.out.println(valor);
		}
	}

	private static Integer scannearOpcaoEConverterEmInteiro() throws NumberFormatException {
		final String valorDigitado = newScanner();
		return Integer.parseInt(valorDigitado);

	}

	@SuppressWarnings("resource")
	private static String newScanner() {
		return new Scanner(System.in).nextLine();
	}

	private static Double scannearValorASerConvertidoEConverterEmDouble() throws NumberFormatException {
		final String valor = newScanner();
		return Double.valueOf(valor);

	}

	private static void body() {
		
		imprimirTexto(
				"Escolha uma das opções abaixo: ", 
				MessageFormat.format("1- {0}", TipoConversao.DE_CELSIUS_PARA_FAHRENHEIT), 
				MessageFormat.format("2- {0}", TipoConversao.DE_CELSIUS_PARA_KELVIN), 
				MessageFormat.format("3- {0}", TipoConversao.DE_CELSIUS_PARA_RANKINE),
				MessageFormat.format("4- {0}", TipoConversao.DE_CELSIUS_PARA_REAUMUR),
				"5- Todos",
				"0- Para Sair");
	}

	private static void header() {
		System.out.println("################################################");
		System.out.println("####################Conversor###################");
		System.out.println("################################################");
		System.out.println("Let me do the hardWork to U!\n\n");
	}

}
