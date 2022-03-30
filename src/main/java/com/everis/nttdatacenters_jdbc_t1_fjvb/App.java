package com.everis.nttdatacenters_jdbc_t1_fjvb;

import java.sql.DriverManager;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{

		// Conectar
		Conecction();

	}

	private static void Conecction() {

		// Datos de la conexión
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String usuario = "usuario";
		String clave = "clave";
		Connection dbConnection = null;
		Statement statement = null;

		try {

			// Driver de la conexión
			Class.forName(driver);

			// Conectar
			dbConnection = DriverManager.getConnection(url, usuario, clave);

			// Consulta
			statement = dbConnection.createStatement();
			final String query = "SELECT id, username, password, nombre FROM Usuarios";
			final ResultSet rs = statement.executeQuery(query);

			// Tratar los datos
			StringBuilder user1 = new StringBuilder();
			while(rs.next()) {
				String id = rs.getString("ID");
				String usr = rs.getString("USERNAME");
				String psw = rs.getString("PASSWORD");
				String nombre = rs.getString("NOMBRE");
				System.out.println("userid : " + id);
				System.out.println("usr : " + usr);
				System.out.println("psw : " + psw);
				System.out.println("nombre : " + nombre);
			}


			// Cerrar conexión
			dbConnection.close();

			// En caso de excepción
		} catch (ClassNotFoundException | SQLException e) {

			// Mostrar por consola
			System.out.println( "ERROR CONEXION" );

		}
	}
}