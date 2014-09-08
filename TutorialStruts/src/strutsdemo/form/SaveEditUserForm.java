package strutsdemo.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SaveEditUserForm extends ActionForm {

	private String idUsuario;
	private String login;
	private String nome;
	private String ativo;
	private String faixaIdade;
	private String sexo;
	private String senhaAntiga;
	private String novaSenha;
	private String confirmacaoNovaSenha;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		idUsuario = "-1";
		login = "";
		nome = "";
		ativo = "false";
		faixaIdade = "1";
		sexo = "M";
		senhaAntiga = "";
		novaSenha = "";
		confirmacaoNovaSenha = "";

	}

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
		if ((novaSenha == null) || (novaSenha.length() < 1)) {
			errors.add("nome", new ActionMessage("error.novaSenha.required"));
		}
		if ((confirmacaoNovaSenha == null)
				|| (confirmacaoNovaSenha.length() < 1)) {
			errors.add("confirmacaoNovaSenha", new ActionMessage(
					"error.confirmacaoNovaSenha.required"));
		}
		if ((senhaAntiga == null) || (senhaAntiga.length() < 1)) {
			errors.add("senhaAntiga", new ActionMessage(
					"error.senhaAntiga.required"));
		}
		if (errors.isEmpty()) {
			if (!novaSenha.equals(confirmacaoNovaSenha)) {
				errors.add("senhaAntiga", new ActionMessage(
						"error.ConfirmacaoSenha"));
			}
		}
		return errors;
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

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
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

	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmacaoNovaSenha() {
		return confirmacaoNovaSenha;
	}

	public void setConfirmacaoNovaSenha(String confirmacaoNovaSenha) {
		this.confirmacaoNovaSenha = confirmacaoNovaSenha;
	}

}
