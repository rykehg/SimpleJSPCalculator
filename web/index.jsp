<%@page import="negocio.Divisao"%>
<%@page import="negocio.Multiplicacao"%>
<%@page import="negocio.Subtracao"%>
<%@page import="negocio.Adicao"%>
<%@page import="negocio.Calculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h3>Henrique Hessel Gaeta - ADS - Matutino</h3>
        <br>
        
        <h2>Insira os números: </h2>
        <form action="ServletCalculo">
            Primeiro número: <input type="text" name="valor1"><br>
            Segundo número: <input type="text" name="valor2"><br>
            <input type='submit' name='btnCalcular' value='+'>&nbsp;
            <input type='submit' name='btnCalcular' value='-'>&nbsp;
            <input type='submit' name='btnCalcular' value='x'>&nbsp;
            <input type='submit' name='btnCalcular' value='/'>
        </form>
        <%
            if(request.getAttribute("btnCalcular") != null || request.getAttribute("valor1") != null || request.getAttribute("valor2") != null) {
                RequestDispatcher rd = request.getRequestDispatcher("ServletCalculo");
                request.setAttribute("valor1", Float.parseFloat(request.getParameter("valor1")));
                request.setAttribute("valor2", Float.parseFloat(request.getParameter("valor2")));    
                rd.forward(request, response);
            }                                 
        %>
    </body>
</html>
