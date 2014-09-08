package strutsdemo.action;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import strutsdemo.bean.UserDAO;
import strutsdemo.bean.UserData;

public class EditUserAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();

		try {
			HttpSession session = request.getSession();

			UserDAO dao = new UserDAO();

			String idUsuario = request.getParameter("idUsuario");

			LinkedList userList = (LinkedList) session
					.getAttribute("userListBean");

			Iterator iter = userList.iterator();

			while (iter.hasNext()) {
				UserData user = (UserData) iter.next();
				if (user.getIdUsuario() == Integer.parseInt(idUsuario)) {
					session.setAttribute("editUserBean", user);
					break;
				}

			}

			UserData user = (UserData) session.getAttribute("editUserBean");
			if (user == null) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"error.user.notFound"));
			}

		} catch (Exception e) {
			errors.add(new ActionErrors().GLOBAL_MESSAGE, new ActionMessage(
					"error.get.user"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("failure"));
		} else {

			return (mapping.findForward("sucess"));
		}
	}

}
