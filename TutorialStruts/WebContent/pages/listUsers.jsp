<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>

<logic:notPresent name="userListBean" scope="session">
	<logic:redirect forward="error" />
</logic:notPresent>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html >
<head>
<title><bean:message key="users.title" /></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<font face="Comic Sans MS" size="3" />
		<blockquote>
			<center>
				<h3>
					<font color="blue"> <bean:message key="users.title" /></font>
				</h3>
				<table width="80%" border="1">
					<tr>
						<th width="10%"><bean:message key="prompt.idUsuario" /></th>
						<th width="50%"><bean:message key="prompt.nome" /></th>
						<th width="20%"><bean:message key="prompt.login" /></th>
						<th width="10%"><bean:message key="prompt.ativo" /></th>
						<th width="10%"></th>
					</tr>

					<%-- loop percorrendo a lista de usuarios --%>

					<logic:iterate name="userListBean" id="user"></logic:iterate>

					<tr>
						<td align="center"><bean:write name="user"
								property="idUsuario" /></td>

						<td><html:link page="/editUser.do" paramId="idUsuario"
								paramName="user" paramProperty="idUsuario">
								<bean:write name="user" property="nome" />

							</html:link>
						<td><bean:write name="user" property="login" /></td>
						<td><bean:write name="user" property="descricaoStatus" /></td>

						<td><html:link page="/deleteUser.do" paramId="idUsuario"
								paramName="user" paramProperty="idUsuario">
								<bean:message key="prompt.excluir" />
							</html:link></td>
					</tr>
				</table>
				<br />
				<html:link page="/insertUser.do">Incluir</html:link>
				<html:link page="/Welcome.do">Pagina Inicial</html:link>
			</center>


		</blockquote>

	</center>






</body>
</html:html>