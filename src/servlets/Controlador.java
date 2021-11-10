package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Controlador/paises", "/Controlador/estados"})
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String BRASIL= "Brasil";
	private static final String MEXICO= "Mexico";

	private static final String[] PAISES= {BRASIL, MEXICO};

	private static final String[] ESTADOS_BRASIL= iniciarEstadosBrasil();
	private static final String[] ESTADOS_MEXICO= iniciarEstadosMexico();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao= request.getServletPath();

		if(acao.equalsIgnoreCase("/Controlador/paises"))
			apresentarEtapaPaises(request, response);

		if(acao.equalsIgnoreCase("/Controlador/estados"))
			apresentarEtapaEstados(request, response);
	}	

	private void apresentarEtapaPaises(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("paises", PAISES);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void apresentarEtapaEstados(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String pais= request.getParameter("pais");
		String[] estados= null;
		String resposta= "";
	
		if(pais != null) {
			if(pais.equalsIgnoreCase(BRASIL))
				estados= ESTADOS_BRASIL;

			if(pais.equalsIgnoreCase(MEXICO))
				estados= ESTADOS_MEXICO;	
			
			for(int i=0; i<estados.length; i++)
				resposta+= estados[i] + ";";
		}
		
		response.setContentType("text/html; charset=ISO-8859-1");
		response.getWriter().write(resposta);
		response.flushBuffer();
	}

	private static String[] iniciarEstadosBrasil() {

		return new String[]{"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo",
				"Goiá", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", 
				"Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", 
				"Tocantins", "Distrito Federal"};
	}

	private static String[] iniciarEstadosMexico() {

		return new String[]{"Aguascalientes", "Baja California", "Baja California", "Campeche", "Chiapas", 
				"Chihuahua", "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", 
				"México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", 
				"Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", 
				"Veracruz", "Yucatán", "Zacatecas", "Cidade do México"};
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
