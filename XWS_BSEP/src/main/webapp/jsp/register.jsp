<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <form:form id="regForm" modelAttribute="Banka" action="banke/register" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="email">Email</form:label>
                        </td>
                        <td>
                            <form:input path="email" name="email" id="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="drzava">Drzava</form:label>
                        </td>
                        <td>
                            <form:input path="drzava" name="drzava" id="drzava" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="imeBanke">Ime Banke</form:label>
                        </td>
                        <td>
                            <form:input path="imeBanke" name="imeBanke" id="imeBanke" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="adresa">Adresa</form:label>
                        </td>
                        <td>
                            <form:input path="adresa" name="adresa" id="adresa" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="address">Address</form:label>
                        </td>
                        <td>
                            <form:input path="address" name="address" id="address" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="swift">Swift</form:label>
                        </td>
                        <td>
                            <form:input path="swift" name="swift" id="swift" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="telefon">Telefon</form:label>
                        </td>
                        <td>
                            <form:input path="telefon" name="telefon" id="telefon" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="racun">Racun</form:label>
                        </td>
                        <td>
                            <form:input path="racun" name="racun" id="racun" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>