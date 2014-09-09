package strutsdemo.action;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.DynaValidatorForm;

import strutsdemo.bean.UserDAO;
import strutsdemo.bean.UserData;
import strutsdemo.form.SaveEditUserForm;
import strutsdemo.form.SaveInsertUserForm;

public class SaveInsertUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();

		SaveInsertUserForm userForm = (SaveInsertUserForm) form;

	//	UserData user = (UserData) request.getAttribute("insertUserBean");

		UserData user = new UserData();
		
		user.setNome(userForm.getNome());
		user.setLogin(userForm.getLogin());
		user.setIdUsuario(Integer.parseInt(userForm.getIdUsuario()));
		user.setDescricaoStatus(Boolean.parseBoolean(userForm
				.getDescricaoStatus()));
		user.setFaixaIdade(Integer.parseInt(userForm.getFaixaIdade()));
		user.setSenha(userForm.getSenha());
		user.setSexo(userForm.getSexo());

		UserDAO dao = new UserDAO();

		System.out.println(user.getSenha());
		
		dao.insertUser(user);

		 LinkedList userList = (LinkedList)
		 session.getAttribute("userListBean");
		 userList.add(user);
		 session.removeAttribute("insertUserBean");

		return mapping.findForward("sucess");
	}

}
