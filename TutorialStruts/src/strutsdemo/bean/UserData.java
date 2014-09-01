package strutsdemo.bean;

public class UserData {

	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String sexo;
	private boolean ativo;
	private int faixaIdade;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getFaixaIdade() {
		return faixaIdade;
	}

	public void setFaixaIdade(int faixaIdade) {
		this.faixaIdade = faixaIdade;
	}

}
