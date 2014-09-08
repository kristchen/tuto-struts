package strutsdemo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConnection(){
		Connection conn = null;
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/strutsdemo","root","root");
		System.out.println("Conexão bem sucedida");
		
		}catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		return conn;
	}
	
	public static void main(String[] args) {
		
		
	new Conexao().getConnection();
	
		
		
		
	}
	
}
