package strutsdemo.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserData extends ActionForm {

	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String sexo;
	private boolean descricaoStatus;
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

	

	public boolean getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(boolean descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public int getFaixaIdade() {
		return faixaIdade;
	}

	public void setFaixaIdade(int faixaIdade) {
		this.faixaIdade = faixaIdade;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(mapping, request);
	}

}
