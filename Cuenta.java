import java.util.Date;

public class Cuenta {
	private int numeroCuenta;
	private double saldo;
	private Date fechaApertura;
	private Cliente titular;
	
	//constructor
	public Cuenta(int numeroCuenta, double saldo, Date fechaApertura, Cliente titular) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
		this.titular = titular;
		}
	
	public Cuenta(int numeroCuenta, double saldo, Date fechaApertura) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
	}
	
	//Getter y Setters
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}	
	
}
