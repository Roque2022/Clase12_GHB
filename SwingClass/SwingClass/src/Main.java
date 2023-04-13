import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gui00 pantalla1 = new Gui00();

		 Gui01 pantalla2 = new Gui01();
		// pantalla2.setBounds(650, 5, 350, 350);

	Gui04 pantalla3 = new Gui04();
//		pantalla3.setBounds(0, 0, 550, 450);

	//	Conexion();
		
	//	conexion2();
		
	//	conexion3();

	}

	// BASE DE DATOS
	public static void Conexion() {
		// Ruta de nuestra base de datos

		String servidor = "jdbc:mysql://localhost:3306/";

		String DBnombre = "argentina2023";
		// Nuestra librería mysql

		String driver = "com.mysql.jdbc.Driver";
		// Nombre de usuario de mysql

		String username = "root";
		// Clave de usuario de mysql

		String password = "crac";

		// Objeto del tipo Connection para crear la conexión

		Connection con;

		try {
			// Cargar drivers de MySQL
			Class.forName(driver);

			// Establecer la conexion con la base de datos
			con = DriverManager.getConnection(servidor + DBnombre, username, password);

			System.out.println("Conexión realizada a la base de datos con éxito.");

			String Selectquery = "select * from empleado";

			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery(Selectquery);

			while (rs.next()) {
				System.out.println(".... Registro n°: " + rs.getRow() + " ..........." + "\n");
				System.out.println("Nombre y apellido: " + rs.getString("nombre") + ", " + rs.getString("apellido"));
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("Depto.: " + rs.getString("Depto") + "\n");

			}

			// Cerramos las conexiones, en orden inverso a su apertura
			st.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error!, conexión fallida a la base de datos.");
		}
	}

	public static void conexion2() {
		try {
			ConexionBD conn = new ConexionBD();
			Connection conexion = conn.getConnection(); 
			// usar executeUpdate para un insert,delete u update

			String Insertquery = "INSERT INTO empleado (DNI,nombre,apellido,nacionalidad,Depto)\r\n" + "VALUES"
					+ "(?,?,?,?,?)";
			// preparo la sentencia
			PreparedStatement PS = conexion.prepareStatement(Insertquery);
			PS.setInt(1, 99000111); 
			PS.setString(2, "Claudio");
			PS.setString(3, "Caniggia");
			PS.setString(4, "Argentino");
			PS.setString(5, "logistica");
			// + "(99000111,"Diego','Maradona','Argentino','logistica')";
			// execute insert SQL stetement
			PS.executeUpdate();

			System.out.println("El registro fue exitoso!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	public static void conexion3() {
		try {
			ConexionBD conn = new ConexionBD();
			Connection conexion = conn.getConnection();
			
			
			
			String Insertquery = "insert into empleado(DNI,nombre,apellido,nacionalidad,Depto) values (99000222,'Juan','Perez','Argentino','logistica')";
			
			String Updatequery = "UPDATE empleado SET DNI = 55222333, nombre = 'Roman', apellido = 'Riquelme', Depto='Logistica'\r\n"
					+ "WHERE idEmpleado=5";

			String Deletequery = "delete from empleado where  idEmpleado in (6,11,13,12)";

			PreparedStatement sentencia = conexion.prepareStatement(Insertquery);
			PreparedStatement sentencia2 = conexion.prepareStatement(Updatequery);
		  PreparedStatement sentencia3 = conexion.prepareStatement(Deletequery);
			
		// sentencia.executeUpdate();
			//sentencia2.executeUpdate();
		
	
	
	
	
	sentencia3.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error!"
					+ e);
		}
		
	}
	
}
