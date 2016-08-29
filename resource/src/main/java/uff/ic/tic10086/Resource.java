package uff.ic.tic10086;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jena.rdf.model.Model;

public class Resource extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DOMAIN = "localhost";
    private static final String SPARQL_PORT = ":8080";
    private static final String SPARQL_URL_TEMPLATE = "http://" + DOMAIN + SPARQL_PORT + "/fuseki/%1s";

    @Override
    public void init(ServletConfig config) throws ServletException {
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getParameter("id");
        String accept = request.getHeader("Accept");

        Model model = getDescription(request, uri);
        OutputStream output = response.getOutputStream();

        output.flush();
        output.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Error: POST method not implemented.");
    }

    private Model getDescription(HttpServletRequest request, String uri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
