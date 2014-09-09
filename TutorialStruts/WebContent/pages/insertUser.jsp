<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html>
<head>
<title><bean:message key="insertUser.title" /></title>
</head>
<body>
	<font face="Comic Sans MS" size="3"> •
		<center>
			<h3>
				<font color="blue"><bean:message key="insertUser.title" /></font>
			</h3>

			<html:form action="/saveInsertUser.do" method="post"
				
				focus="idUsuario">
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
						<td align="right"><bean:message key="prompt.idUsuario"
								name="insertUserBean" />:</td>
						<logic:equal name="insertUserBean" property="idUsuario" value="0">
							<td align="left"><html:text property="idUsuario" size="5"
									value="" /></td>
						</logic:equal>
						<logic:notEqual name="insertUserBean" property="idUsuario"
							value="0">
							<td align="left"><html:text property="idUsuario" size="5"
									name="insertUserBean" /></td>
						</logic:notEqual>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.login" />:</td>
						<td align="left"><html:text property="login" size="20"
								name="insertUserBean" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.nome" /></td>
						<td align="left"><html:text property="nome" size="60"
								name="insertUserBean" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.senha" />:</td>
						<td align="left"><html:password property="senha" size="16"
								maxlength="20" redisplay="false" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.confirmacaoSenha" />:
						</td>
						<td align="left"><html:password property="confirmacaoSenha"
								size="16" maxlength="20" redisplay="false" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.faixaIdade" />:</td>
						<td align="left"><html:select property="faixaIdade"
								name="insertUserBean">
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
								name="insertUserBean">
								<bean:message key="prompt.Masculino" />
							</html:radio> <html:radio property="sexo" value="F" name="insertUserBean">
								<bean:message key="prompt.Feminino" />
							</html:radio></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="prompt.ativo" />:</td>
						<td align="left"><html:checkbox property="descricaoStatus"
								titleKey="prompt.ativo" name="insertUserBean" /></td>
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