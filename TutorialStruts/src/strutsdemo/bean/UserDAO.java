package strutsdemo.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import strutsdemo.connection.Conexao;

public class UserDAO {

	private Connection connection;

	public LinkedList<UserData> getUserList() throws SQLException {

		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<UserData> users = new LinkedList<UserData>();

		try {
			this.connection = new Conexao().getConnection();

			stmt = connection.prepareStatement("select * from usuario");

			rs = stmt.executeQuery();

			while (rs.next()) {
				UserData user = new UserData();
				user.setIdUsuario(rs.getInt("id_usuario"));
				user.setNome(rs.getString("nome"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				user.setSexo(rs.getString("sexo"));
				user.setDescricaoStatus(rs.getBoolean("ativo"));
				user.setFaixaIdade(rs.getInt("faixa_idade"));

				users.add(user);

			}

		} finally {

		}

		return users;
	}

	@SuppressWarnings("null")
	public void insertUser(UserData user) throws SQLException {
		@SuppressWarnings("unused")
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			this.connection = new Conexao().getConnection();

			@SuppressWarnings("unused")
			String sql = "insert into usuario \n"
					+ "(id_usuario, nome, login, senha, sexo, ativo, faixa_idade) \n";
			stmt.setInt(1, user.getIdUsuario());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getLogin());
			stmt.setString(4, user.getSenha());
			stmt.setString(5, user.getSexo());
			stmt.setBoolean(6, user.getDescricaoStatus());
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
		this.connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			this.connection = new Conexao().getConnection();
			String sql = "update usuario set \n"
					+ "nome = ?, login = ?, senha = ?, sexo = ?, ativo = ?, faixa_idade = ? \n"
					+ "where id_usuario = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getSexo());
			short ativo = (short) (user.getDescricaoStatus() ? 1 : 0);
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
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			this.connection = new Conexao().getConnection();
			stmt = connection
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

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
