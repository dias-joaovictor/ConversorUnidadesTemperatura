package util;

public final class Conversor {
	
	public static Double converterCelsiusFahrenheit(Double valorCelsius) {
		return ((9 * valorCelsius/5) + 32);
	}
	
	public static Double converterCelsiusKelvin(Double valorCelsius) {
		return (valorCelsius + 273.15);
	}
	
	public static Double converterCelsiusReaumur(Double valorCelsius) {
		return (valorCelsius * 4/5);
	}
	
	public static Double converterCelsiusRankine(Double valorCelsius) {
		return (converterCelsiusKelvin(valorCelsius) * 1.8);
	}

}
