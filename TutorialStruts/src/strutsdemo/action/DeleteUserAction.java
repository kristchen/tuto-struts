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

import strutsdemo.bean.UserDAO;
import strutsdemo.bean.UserData;

public class DeleteUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();

		HttpSession session = request.getSession();

		String idUsuario = request.getParameter("idUsuario");

		LinkedList userList = (LinkedList) session.getAttribute("userListBean");
		Iterator iter = userList.iterator();

		while (iter.hasNext()) {

			UserData user = (UserData) iter.next();

			if (user.getIdUsuario() == Integer.parseInt(idUsuario)) {

				UserDAO dao = new UserDAO();
				dao.deleteUser(Integer.parseInt(idUsuario));

				userList.remove(user);
				break;
			}
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("failure");
		} else {

			return mapping.findForward("sucess");
		}
	}

}
