package strutsdemo.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import strutsdemo.bean.UserDAO;
import strutsdemo.bean.UserData;
import strutsdemo.form.SaveEditUserForm;

public class SaveEditUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();

		try {
			
			HttpSession session = request.getSession();
			
			SaveEditUserForm editUserForm = (SaveEditUserForm) form;

			UserData user = (UserData) session.getAttribute("editUserBean");
			if (!editUserForm.getSenhaAntiga().equals("zzzzz")) {
				if (!user.getSenha().equals(editUserForm.getSenhaAntiga())) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"error.senhaAntiga"));
				}
			}

			if (errors.isEmpty()) {
				BeanUtils.copyProperties(user, editUserForm);
				UserDAO dao = new UserDAO();
				dao.updateUser(user);

			}

		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"error.update.user"));
			getServlet().log("alterando o usuario", e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("failure");
		} else {

			return mapping.findForward("sucess");

		}
	}

}
