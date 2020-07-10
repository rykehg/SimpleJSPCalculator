package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Adicao;
import negocio.Calculo;
import negocio.Divisao;
import negocio.Multiplicacao;
import negocio.Subtracao;

@WebServlet(name = "ServletCalculo", urlPatterns = {"/ServletCalculo"})
public class ServletCalculo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCalculo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if (!request.getParameter("valor1").equals("") || !request.getParameter("valor2").equals("")){
                float v1 = Float.parseFloat(request.getParameter("valor1")); 
                float v2 = Float.parseFloat(request.getParameter("valor2"));
                if(Float.parseFloat(request.getParameter("valor2")) != 0 || !request.getParameter("btnCalcular").equals("/")){                    
                    Calculo objCalculadora = null;
                    // verifica a operação desejada
                    switch(request.getParameter("btnCalcular")){
                        // via upcasting, utiliza apenas um único objeto para qualquer das operações
                        case "+":
                            objCalculadora = new Adicao(v1, v2); 
                            break;
                        case "-":
                            objCalculadora = new Subtracao(v1, v2); 
                            break;
                        case "x":
                            objCalculadora = new Multiplicacao(v1, v2); 
                            break;
                        case "/":
                            objCalculadora = new Divisao(v1, v2); 
                            break;
                    }                
                    float resultado = objCalculadora.calcular();
                    RequestDispatcher rd = request.getRequestDispatcher("exibeResultado.jsp");
                    // inclui o resultado da média como atributo do "request"
                    request.setAttribute("resultado", resultado);
                    rd.forward(request, response);
                } else{
                    out.println("<br><h3>O valor2 da divisão não pode ser 0.</h3>");
                }
            } else{
                out.println("<br><h3>O campo dos valores não deve ser nulo.</h3>");
            }
            out.println("</body>");
            out.println("</html>");
        } 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
