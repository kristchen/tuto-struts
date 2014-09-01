package strutsdemo.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdminUsers {

	protected static DataSource dataSource;

	public AdminUsers() throws Exception {

		if (dataSource == null) {
			try {
				InitialContext ic = new InitialContext();

				dataSource = (DataSource) ic.lookup("java:jdbc/StrutsDemoDS");

			} catch (NamingException ex) {
				System.out.println(ex.getMessage());
				throw ex;
			}
		}

	}

	protected Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw e;
		}

		return conn;
	}

	protected void closeConnection(Connection conn, PreparedStatement stmt,
			ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	public LinkedList<UserData> getUserList() throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<UserData> users = new LinkedList<UserData>();

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM USUARIO");

			rs = stmt.executeQuery();

			while (rs.next()) {
				UserData user = new UserData();
				user.setIdUsuario(rs.getInt("id_usuario"));
				user.setNome(rs.getString("nome"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				user.setSexo(rs.getString("sexo"));
				user.setAtivo(rs.getBoolean("ativo"));
				user.setFaixaIdade(rs.getInt("faixa_idade"));

				users.add(user);

			}

		} finally {
			closeConnection(conn, stmt, rs);
		}

		return users;
	}

	public void insertUser(UserData user) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "insert into usuario \n"
					+ "(id_usuario, nome, login, senha, sexo, ativo, faixa_idade) \n";
			stmt.setInt(1, user.getIdUsuario());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getLogin());
			stmt.setString(4, user.getSenha());
			stmt.setString(5, user.getSexo());
			stmt.setBoolean(6, user.isAtivo());
			stmt.setInt(7, user.getFaixaIdade());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();

			}

		}
	}

	public void updateUser(UserData user) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "update usuario set \n"
					+ "nome = ?, login = ?, senha = ?, sexo = ?, ativo = ?, faixa_idade = ? \n"
					+ "where id_usuario = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getSexo());
			short ativo = (short) (user.isAtivo() ? 1 : 0);
			stmt.setShort(5, ativo);
			stmt.setInt(6, user.getFaixaIdade());
			stmt.setInt(7, user.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public void deleteUser(int idUsuario) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn
					.prepareStatement("delete from usuario where id_usuario = ?");
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}