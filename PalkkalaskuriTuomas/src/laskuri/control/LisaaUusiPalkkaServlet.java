package laskuri.control;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class LisaaUusiPalkkaServlet
 */
@WebServlet("/lisaa-palkka")
public class LisaaUusiPalkkaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LisaaUusiPalkkaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// haetaan tiedot sessiosta
		HttpSession session = request.getSession();
		session.getAttribute("netto");
		session.getAttribute("bruttopalkka");
		
		String jsp = "/view/palkkalomake.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		
			// palkan tiedot parametreina
			String nimi = request.getParameter("nimi");
			String bruttoStr = request.getParameter("brutto");
			double brutto = new Double(bruttoStr);
			String nettoStr = request.getParameter("netto");
			double netto = new Double(nettoStr);
		
			// Luodaan uusi palkka edellisill‰ parametreilla
			Palkka palkka = new Palkka(0, nimi, brutto, netto);
			
			// Luodaan palkkadao
			PalkkaDAO palkkadao = new PalkkaDAO();
	
			
			// Lis‰t‰‰n palkan tiedot tietokantaan
			palkkadao.addPalkka(palkka);
		} catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}

		// uudelleenohjataan selain pizzalista-sivulle
		response.sendRedirect("listaa-palkat");
	}
	

}
