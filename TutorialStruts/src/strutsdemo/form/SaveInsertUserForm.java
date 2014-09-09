package strutsdemo.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SaveInsertUserForm extends ActionForm {
	private String idUsuario;
	private String login;
	private String nome;
	private String descricaoStatus;
	private String faixaIdade;
	private String sexo;
	private String senha;
	private String confimacaoSenha;

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfimacaoSenha() {
		return confimacaoSenha;
	}

	public void setConfimacaoSenha(String confimacaoSenha) {
		this.confimacaoSenha = confimacaoSenha;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrisaoStatus() {
		return descricaoStatus;
	}

	public void setDescrisaoStatus(String descrisaoStatus) {
		this.descricaoStatus = descrisaoStatus;
	}

	public String getFaixaIdade() {
		return faixaIdade;
	}

	public void setFaixaIdade(String faixaIdade) {
		this.faixaIdade = faixaIdade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNovaSenha() {
		return senha;
	}

	public void setNovaSenha(String novaSenha) {
		this.senha = novaSenha;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.idUsuario = "";
		this.login = "";
		this.nome = "";
		this.descricaoStatus = "false";
		this.faixaIdade = "";
		this.sexo = "";
		this.senha = "";
		this.confimacaoSenha = "";
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if ((idUsuario == null) || (idUsuario.length() < 1)) {
			errors.add("idUsuario", new ActionMessage(
					"error.idUsuario.required"));
		}
		if ((login == null) || (login.length() < 1)) {
			errors.add("login", new ActionMessage("error.login.required"));
		}
		if ((nome == null) || (nome.length() < 1)) {
			errors.add("nome", new ActionMessage("error.nome.required"));
		}

		if ((senha == null) || (senha.length() < 1)) {
			errors.add("nome", new ActionMessage("error.novaSenha.required"));
		}

//		if (!(confimacaoSenha.equals(senha) && confimacaoSenha.length() == senha
//				.length())) {
//
//			errors.add("nome", new ActionMessage("error.ConfirmacaoSenha"));
//
//		}

		return errors;

	}

}
