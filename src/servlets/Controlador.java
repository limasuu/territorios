package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Estado;

@WebServlet(urlPatterns = {"/Controlador/paises", "/Controlador/estados", "/Controlador/dadosEstado"})
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String BRASIL= "Brasil";
	private static final String MEXICO= "Mexico";

	private static final String[] PAISES= {BRASIL, MEXICO};

	private static final String[] ESTADOS_BRASIL= iniciarEstadosBrasil();
	private static final String[] ESTADOS_MEXICO= iniciarEstadosMexico();

	private static final HashMap<String, Estado> DADOS_ESTADOS_BRASIL= iniciarDadosEstadosBrasil();
	private static final HashMap<String, Estado> DADOS_ESTADOS_MEXICO= iniciarDadosEstadosMexico();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao= request.getServletPath();

		if(acao.equalsIgnoreCase("/Controlador/paises"))
			apresentarEtapaPaises(request, response);

		if(acao.equalsIgnoreCase("/Controlador/estados"))
			apresentarEtapaEstados(request, response);
		
		if(acao.equalsIgnoreCase("/Controlador/dadosEstado"))
			apresentarEtapaDadosEstado(request, response);
	}	

	private void apresentarEtapaPaises(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("paises", PAISES);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void apresentarEtapaEstados(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String pais= request.getParameter("pais");
		String[] estados= null;
		String resposta= "";

		if(pais != null && !pais.equalsIgnoreCase("Selecione")) {
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
	
	private void apresentarEtapaDadosEstado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String pais= request.getParameter("pais");
		String estado= request.getParameter("estado");
		String resposta= "";
		
		if(pais != null && estado != null && !pais.equalsIgnoreCase("Selecione") && !estado.equalsIgnoreCase("Selecione")) {
			Estado dados_estado= null;
			
			if(pais.equalsIgnoreCase(BRASIL))
				dados_estado= DADOS_ESTADOS_BRASIL.get(estado);
			
			if(pais.equalsIgnoreCase(MEXICO))
				dados_estado= DADOS_ESTADOS_MEXICO.get(estado);
			
			resposta= "Nome: " + dados_estado.getNome() + "\n";
			resposta+= "Sigla: " + dados_estado.getSigla() + "\n";
			resposta+= "Capital: " + dados_estado.getCapital() + "\n";
			resposta+= "Área: " + dados_estado.getArea() + " km²";	
		}
		
		response.setContentType("text/html; charset=ISO-8859-1");
		response.getWriter().write(resposta);
		response.flushBuffer();
	}

	private static String[] iniciarEstadosBrasil() {

		return new String[]{"Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", "Ceara", "Espirito Santo",
				"Goias", "Maranhao", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", 
				"Paraiba", "Parana", "Pernambuco", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondonia", "Roraima", "Santa Catarina", "Sao Paulo", "Sergipe", 
				"Tocantins", "Distrito Federal"};
	}

	private static String[] iniciarEstadosMexico() {

		return new String[]{"Aguascalientes", "Baja California", "Baja California", "Campeche", "Chiapas", 
				"Chihuahua", "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", 
				"Mexico", "Michoacan", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", 
				"Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", 
				"Veracruz", "Yucatan", "Zacatecas", "Cidade do Mexico"};
	}

	private static HashMap<String, Estado> iniciarDadosEstadosBrasil() {

		HashMap<String, Estado> estados= new HashMap<String, Estado>();
		Estado estado;

		estado= new Estado("Acre", "Brasil", "AC", "Rio Branco", 164122.2);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Alagoas", "Brasil", "AL", "Maceio", 27767.7);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Amapa", "Brasil", "AP", "Macapa", 142814.6);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Amazonas", "Brasil", "AM", "Manaus", 1570745.7);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Bahia", "Brasil", "BA", "Salvador", 564692.7);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Ceara", "Brasil", "CE", "Fortaleza", 148825.6);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Distrito Federal", "Brasil", "DF", "Brasilia", 5822.1);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Espirito Santo", "Brasil", "ES", "Vitoria", 46077.5);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Goias", "Brasil", "GO", "Goiania", 340086.7);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Maranhao", "Brasil", "MA", "Sao Luis", 331983.3);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Mato Grosso", "Brasil", "MT", "Cuiaba", 903357.9);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Mato Grosso do Sul", "Brasil", "MS", "Campo Grande", 357125.0);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Minas Gerais", "Brasil", "MG", "Belo Horizonte", 586528.3);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Para", "Brasil", "PA", "Belem", 1247689.5);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Paraiba", "Brasil", "PB", "Joao Pessoa", 56439.8);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Parana", "Brasil", "PR", "Curitiba", 199314.9);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Pernambuco", "Brasil", "PE", "Recife", 98311.6);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Piaui", "Brasil", "PI", "Teresina", 251529.2);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Rio de Janeiro", "Brasil", "RJ", "Rio de Janeiro", 43696.1);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Rio Grande do Norte", "Brasil", "RN", "Natal", 52796.8);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Rio Grande do Sul", "Brasil", "RS", "Porto Alegre", 281748.5);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Rondonia", "Brasil", "RO", "Porto Velho", 237576.2);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Roraima", "Brasil", "RR", "Boa Vista", 224299.0);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Santa Catarina", "Brasil", "SC", "Florianopolis", 95346.2);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Sao Paulo", "Brasil", "SP", "Sao Paulo", 248209.4);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Sergipe", "Brasil", "SE", "Aracaju", 21910.3);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Tocantins", "Brasil", "TO", "Palmas", 277620.9);
		estados.put(estado.getNome(), estado);

		return estados;
	}

	private static HashMap<String, Estado> iniciarDadosEstadosMexico() {

		HashMap<String, Estado> estados= new HashMap<String, Estado>();
		Estado estado;

		estado= new Estado("Aguascalientes", "Mexico", "AGS", "Aguascalientes", 5.618);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Baja California Sur", "Mexico", "BC", "Mexicali", 71.446);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Baja California", "Mexico", "BCS", "La Paz", 73.922);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Campeche", "Mexico", "CAMP", "Campeche", 57.924);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Chiapas", "Mexico", "CHIS", "Tuxtla Gutierrez", 73.289);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Chihuahua", "Mexico", "CHIH", "Chihuahua", 247.455);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Cidade do Mexico", "Mexico", "CDMX", "-", 1.495);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Coahuila", "Mexico", "COAH", "Saltillo", 151.563);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Colima", "Mexico", "COL", "Colima", 5.625);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Durango", "Mexico", "DGO", "Durango", 123.451);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Guanajuato", "Mexico", "GTO", "Guanajuato", 30.608);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Guerrero", "Mexico", "GRO", "Chilpancingo", 63.621);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Hidalgo", "Mexico", "HGO", "Pachuca", 20.846);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Jalisco", "Mexico", "JAL", "Guadalajara", 78.599);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Mexico", "Mexico", "MEX", "Toluca", 22.357);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Michoacan", "Mexico", "MICH", "Morelia", 58.643);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Morelos", "Mexico", "MOR", "Cuernavaca", 4.893);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Nayarit", "Mexico", "NAY", "Tepic", 27.815);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Nuevo Leon", "Mexico", "NL", "Monterrey", 64.220);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Oaxaca", "Mexico", "OAX", "Oaxaca", 93.793);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Puebla", "Mexico", "PUE", "Puebla", 34.290);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Queretaro", "Mexico", "QRO", "Queretaro", 11.684);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Quintana Roo", "Mexico", "QR", "Chetumal", 42.361);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("San Luis Potosi", "Mexico", "SLP", "San Luis Potosi", 60.983);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Sinaloa", "Mexico", "SIN", "Culiacan", 57.377);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Sonora", "Mexico", "SON", "Hermosillo", 179.503);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Tabasco", "Mexico", "TAB", "Villahermosa", 24.738);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Tamaulipas", "Mexico", "TAMPS", "Ciudad Victoria", 80.175);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Tlaxcala", "TLAX", "AC", "Tlaxcala", 3.991);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Veracruz", "Brasil", "VER", "Xalapa", 71.820);
		estados.put(estado.getNome(), estado);
		
		estado= new Estado("Yucatan", "Mexico", "YUC", "Merida", 39.612);
		estados.put(estado.getNome(), estado);

		estado= new Estado("Zacatecas", "Mexico", "ZAC", "Zacatecas", 75.539);
		estados.put(estado.getNome(), estado);

		return estados;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
