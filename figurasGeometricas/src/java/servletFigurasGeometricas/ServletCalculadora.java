package servletFigurasGeometricas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Circulo;
import logica.Cuadrado;
import logica.IArea;
import logica.IPerimetro;

@WebServlet(name = "ServletCalculadora", urlPatterns = {"/ServletCalculadora"})
public class ServletCalculadora extends HttpServlet {
    private IArea fg;
    private IPerimetro p;
    
    public void calculadoraArea(IArea fg){
        this.fg = fg;
    }
    
    /**
     *
     * @param p interfaz para calcular el perimetro, recibe las clases que
     * implementen la interfaz
     */
    public void calculadoraPerimetro(IPerimetro p){
        this.p = p;
    }
            
    /**
     *
     * @param request solicitud servlet
     * @param response respuesta servlet
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String figura = request.getParameter("tipofigura");
        String operacion = request.getParameter("operacion");   
        if("cuadrado".equals(figura)){
            double lado = Double.parseDouble(request.getParameter("lado"));
            Cuadrado cuadrado = new Cuadrado(lado);
            
            if("area".equals(operacion)){
                calculadoraArea(cuadrado);
            System.out.println("entro area");}
            else if("perimetro".equals(operacion)){
                calculadoraPerimetro(cuadrado);
            System.out.println("entro p");}
        }
        else if("circulo".equals(figura)){
            double radio = Double.parseDouble(request.getParameter("radio"));
            Circulo circulo =new Circulo(radio);
            if("area".equals(operacion))
                calculadoraArea(circulo);
            else if("perimetro".equals(operacion))
                calculadoraPerimetro(circulo);
        }
        
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCalculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> AREA " + (fg != null ? fg.calcularArea() : "N/A") + "</h1>");
            out.println("<h1> PERIMETRO " + p.calcularPerimetro()+ "</h1>");
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
    }
}
