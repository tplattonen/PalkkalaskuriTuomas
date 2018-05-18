package laskuri.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laskuri.model.dao.PalkkaDAO;

/**
 * Servlet implementation class PoistaPalkkaServlet
 */
@WebServlet("/poista-palkka")
public class PoistaPalkkaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PoistaPalkkaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// Haetaan lomakkeella syötetyn palkan tiedot request-oliolta
			String palkkaidStr = request.getParameter("palkkaid");
			int palkkaid = new Integer(palkkaidStr);
			// Luodaan palkkadao
			PalkkaDAO palkkadao = new PalkkaDAO();
			// Lisätään palkan tiedot tietokantaan
			palkkadao.removePalkka(palkkaid);
			
		} catch (SQLException e) {
			
			System.out
					.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain palkkalista-sivulle
		response.sendRedirect("listaa-palkat");
	}

}