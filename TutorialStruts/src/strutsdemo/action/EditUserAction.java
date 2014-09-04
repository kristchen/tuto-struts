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
import org.apache.struts.action.ActionMessages;

import strutsdemo.bean.AdminUsers;
import strutsdemo.bean.UserData;

public class EditUserAction  extends Action{

	public ActionForward execute( ActionMapping mapping , ActionForm form, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		
		ActionErrors errors = new ActionErrors();
		
		try{
			HttpSession session = request.getSession();
			AdminUsers adminUsers = new AdminUsers();
			String idUsuario = request.getParameter("idUsuario");
			session.removeAttribute("editUserBean");
			LinkedList userList = (LinkedList) session.getAttribute("userListBean");
			
			Iterator iter = userList.iterator();
			
			while(iter.hasNext()){
				UserData user = (UserData) iter.next();
				if(user.getIdUsuario()==Integer.parseInt(idUsuario)){
					session.setAttribute("editUserBean", user);
					break;
				}
								
			}
			
			UserData user = (UserData) session.getAttribute("editUserBean");
			if(user==null){
				errors.add(new ActionMessages());
			}
			
						
			
		}catch (Exception e){
			errors.add(new ActionMessages());
		}
		
		if(!errors.isEmpty()){
			saveErrors(request, errors);
			return (mapping.findForward("failure"));
		}else{
					
		return (mapping.findForward("sucess"));
		}
	}
	
	
	
	
}
