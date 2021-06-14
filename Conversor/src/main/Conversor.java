package main;

public class Conversor {

	public Conversor() {
		// TODO Auto-generated constructor stub
	}
	
	public double celsiusParaKelvin(double c) {
		return c + 273.15;
	}
	
	public double kelvinParaCelcius(double k) {
		return k - 273.15;
	}
	
	public double celciusParaFahrenheit(double c) {
		return c * 1.8 + 32;
	}
	
	public double fahrenheitParaCelcius(double f) {
		return (f-32)/1.8;
	}
	
	public double fahrenheitParaKelvin(double f) {
		return (f-32) * 5/9 + 273.15;
	}
	
	public double kelvinParaFahrenheit(double k) {
		return (k-273.15) * 9/5 + 32 ;		
	}

}
