import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProgramaPrincipal {

	private static List<Cliente> listaClientes = new ArrayList<>();
	private static List<Cuenta> listaCuentas = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Menu
		int opcion = 0;
		
		int codigoCliente = 1;
		while(opcion !=5) {
			
			System.out.println("Menu");
			System.out.println("1. Dar de alta a un cliente");
			System.out.println("2. Dar de alta una cuenta");
			System.out.println("3. Asociar una cuenta a un cliente");
			System.out.println("4. Listar clientes y cuentas");
			System.out.println("5. Salir");
			System.out.println("Selecciones una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				codigoCliente = darAltaCliente(scanner, codigoCliente);
				codigoCliente++;
				break;

			case 2:
				crearCuenta(scanner);
				break;

			case 3:
				codigoCliente = asociarCuentaACliente(scanner);
				break;

			case 4:
				listarClientesYCuentas();
				break;

			case 5:
				scanner.close();
				System.out.println("Programa terminado.");
				break;

			default:
				System.out.println("Opción no valida.");
				break;
			}
		}
	}

	private static int darAltaCliente(Scanner scanner, int codigoCliente) {
		System.out.println("Introduzca el DNI del cliente: ");
		String dni = scanner.nextLine();

		System.out.println("Introduzca el nombre del cliente: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduzca los apellidos del cliente: ");
		String apellidos = scanner.nextLine();

		System.out.println("Introduzca la direccion del cliente: ");
		String direccion = scanner.nextLine();

		System.out.println("Introduzca el telefono del cliente: ");
		String telefono = scanner.nextLine();

		Cliente cliente = new Cliente(codigoCliente, dni, nombre, apellidos, direccion, telefono);
		listaClientes.add(cliente);

		System.out.println("El cliente ha sido dado de alta correctamente con el siguiente código de cliente: "+codigoCliente);
		return codigoCliente;
	}

	private static void crearCuenta(Scanner scanner) {
		System.out.print("Introduzca un numero de cuenta: ");
		int numeroCuenta = Integer.parseInt(scanner.nextLine());

		Cuenta cuenta = new Cuenta(numeroCuenta, 0, new Date());
		listaCuentas.add(cuenta);

		System.out.println("La cuenta ha sido creada correctamente");
	}

	private static int asociarCuentaACliente(Scanner scanner) {
		int codigoCliente;
		int numeroCuenta;
		System.out.print("Introduzca el numero de cuenta: ");
		numeroCuenta = Integer.parseInt(scanner.nextLine());

		Cuenta asociarCuenta = null;
		try {
			asociarCuenta = buscarCuentaPorNumero(numeroCuenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Introduzca el código del cliente: ");
		codigoCliente = Integer.parseInt(scanner.nextLine());

		Cliente asociarCliente = null;
		try {
			asociarCliente = buscarClientePorCodigo(codigoCliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (asociarCuenta != null && asociarCliente != null) {
			asociarCuenta.setTitular(asociarCliente);
			System.out.println("La cuenta se ha asociado al cliente correctamente.");
		}
		return codigoCliente;
	}

	private static void listarClientesYCuentas() {
		System.out.println("Clientes y cuentas asociadas:");
		
		for (Cliente client : listaClientes) {
			System.out.println("Cliente: " + client.getNombre() + " " + client.getApellidos());
			
			System.out.println("Cuentas:");
			for (Cuenta cuenta : obtenerCuentasDeUnCliente(client)) {
				System.out.println("- Número de cuenta: " + cuenta.getNumeroCuenta());
				System.out.println("  Saldo: " + cuenta.getSaldo());
			}
			System.out.println();
		}
	}

	private static List<Cuenta> obtenerCuentasDeUnCliente(Cliente client) {
		List<Cuenta> cuentasCliente = new ArrayList<>();
		
		for (Cuenta cuenta : listaCuentas) {
			if (cuenta.getTitular() == client) {
				cuentasCliente.add(cuenta);
			}
		}
		
		return cuentasCliente;
	}

	private static Cliente buscarClientePorCodigo(int codigoCliente) throws Exception {
		for (Cliente cliente : listaClientes) {
			if (cliente.getCodigoCliente() == codigoCliente) {
				return cliente;
			}
		}

		throw new Exception("El ciente con código " + codigoCliente + " no existe");
	}

	private static Cuenta buscarCuentaPorNumero(int numeroDeCuenta) throws Exception {
		for (Cuenta cuenta : listaCuentas) {
			if (cuenta.getNumeroCuenta() == numeroDeCuenta) {
				return cuenta;
			}
		}

		throw new Exception("La cuenta con número de cuenta " + numeroDeCuenta + " no existe");
	}
}
