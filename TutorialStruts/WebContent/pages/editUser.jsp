<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>

<logic:notPresent name="editUserBean" scope="session">
	<logic:redirect forward="error" />
</logic:notPresent>


<html:html >
<head>
<title><bean:message key="editUser.title" /></title>
</head>
<body>
	<font face="Comic Sans MS" size="3">
		<center>
			<h3>
				<font color="blue"><bean:message key="editUser.title" /></font>
			</h3>
			<html:form action="/saveEditUser.do" method="post" focus="login" >
				<html:hidden property="idUsuario" name="editUserBean" />
				<table width="80%" border="0">
					<tr>
						<td width="30%"></td>
						<td width="70%">
							<%-- exibe os erros de validação --%> <logic:messagesPresent>
								<ul>
									<html:messages id="error">
										<li><bean:write name="error" /></li>
									</html:messages>
								</ul>
							</logic:messagesPresent>
						</td>
					<tr>
					<tr>
						<td align="right"><bean:message key="prompt.idUsuario" />:</td>
						<td align="left"><b><bean:write property="idUsuario"
									name="editUserBean" /></b></td>
					</tr>
					<tr>
						<td align="right"><bean:message key= "prompt.login"/>:</td>
						<td align="left"><html:text property="login"
								name="editUserBean" size="20" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.nome" /></td>
						<td align="left"><html:text property="nome"
								name="editUserBean" size="60" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.senhaAntiga" />:
						</td>
						<td align="left"><html:password property="senhaAntiga"
								size="16" maxlength="20" redisplay="false" value="zzzzz" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.novaSenha" />:</td>
						<td align="left"><html:password property="novaSenha"
								size="16" maxlength="20" redisplay="false" value="zzzzz" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message
								key="prompt.confirmacaoNovaSenha" />:</td>
						<td align="left"><html:password
								property="confirmacaoNovaSenha" size="16" maxlength="20"
								redisplay="false" value="zzzzz" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.faixaIdade" />:</td>
						<td align="left"><html:select property="faixaIdade"
								name="editUserBean">
								<html:option value="1">
									<bean:message key="prompt.ate20" />
								</html:option>
								
								
								
								<html:option value="2">
									<bean:message key="prompt.de21a30" />
								</html:option>
								
								
								<html:option value="3">
									<bean:message key="prompt.de31a40" />
								</html:option>
																							
								
								<html:option value="4">
									<bean:message key="prompt.de41a50" />
								</html:option>
								
								
								<html:option value="5">
									<bean:message key="prompt.de51a60" />
								</html:option>
								
								
								<html:option value="6">
									<bean:message key="prompt.acima60" />
								</html:option>
								
								
							</html:select></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.sexo" />:</td>
						<td align="left"><html:radio property="sexo" value="M"
								name="editUserBean">
								<bean:message key="prompt.Masculino" />
							</html:radio> <html:radio property="sexo" value="F" name="editUserBean">
								<bean:message key="prompt.Feminino" />
							</html:radio></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.ativo" />:</td>
						<td align="left"><html:checkbox property="ativo"
								name="editUserBean" titleKey="prompt.ativo" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><html:submit>
								<bean:message key="button.send" />
							</html:submit> <html:reset>
								<bean:message key="button.reset" />
							</html:reset></td>
					</tr>
				</table>
			</html:form>
			<br />
			<html:link page="/listUsers.do">voltar</html:link>
		</center>
	</font>
</body>
</html:html>