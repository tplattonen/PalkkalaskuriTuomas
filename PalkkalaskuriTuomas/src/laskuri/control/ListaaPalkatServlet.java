package laskuri.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import laskuri.model.Palkka;
import laskuri.model.dao.PalkkaDAO;

/**
 * Servlet implementation class ListaaPalkatServlet
 */
@WebServlet("/listaa-palkat")
public class ListaaPalkatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListaaPalkatServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Luodaan palkkadao instanssi
		PalkkaDAO palkkadao = new PalkkaDAO();
		// kutsutaan findall metodia
		ArrayList<Palkka> palkat = palkkadao.findAll();
		// Talletetaan request-olion alle palkat lista, jotta tiedot ovat käytössä jsp:llä
		request.setAttribute("palkat", palkat);
		
		// lähetä selaimelta tullut pyyntö servletiltä edelleen jsp:lle
		String palkkaLista = "/view/palkkalista.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(palkkaLista);
		dispatcher.forward(request, response);	
	}

	
	

}
