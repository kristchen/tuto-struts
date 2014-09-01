package strutsdemo.controller;

import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import strutsdemo.bean.AdminUsers;

public class ListUsersAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LinkedList users = null;

		ActionErrors errors = null;

		try {
			AdminUsers adminUsers = new AdminUsers();
			users = adminUsers.getUserList();
			HttpSession session = request.getSession();
			session.setAttribute("userListBean", users);
		} catch (SQLException e) {
			errors.add(new ActionErrors());
			getServlet().log("Erro ao carregar a lista de usuários", e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("failure"));

		} else
			return (mapping.findForward("sucess"));

	}

}
