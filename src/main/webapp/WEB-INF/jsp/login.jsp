<%@page import="formation.ecommerce.presentation.springmvc.controller.LoginController"%>
<%@page import="formation.ecommerce.presentation.springmvc.form.LoginForm"%>
<%@include file="includes/commun.jsp" %>
<html>
<head>
<title><s:message code="Utilisateur.login.title" /></title>
</head>
<body>
    <div class="container">
        <form:form commandName="<%=LoginController.LOGIN_FORM %>" method="POST">
            <h2>
                <s:message code="Utilisateur.login.title" />
            </h2>
            <table>
                <tr>
                    <td><label><s:message code="Utilisateur.login.input.login" /></label></td>
                    <td><form:input path="<%=LoginForm.FIELD_LOGIN %>"/></td>
                </tr>
                <tr>
                    <td><label><s:message code="Utilisateur.login.input.password" /></label></td>
                    <td class="tdLabel"><form:password path="<%=LoginForm.FIELD_PASSWORD %>" cssClass="form-control" /></td>
                </tr>
            </table>
            <input type="submit" value="<s:message code="Utilisateur.login.input.submit"/>"/>
        <form:errors path="*" cssClass="erreur" element="div"/>
        </form:form>
    </div>
</body>
</html>