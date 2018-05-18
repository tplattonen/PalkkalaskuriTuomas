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


@WebServlet("/muuta-palkka")
public class MuutaPalkkaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MuutaPalkkaServlet() {
        super();
      
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// uudelleenohjataan selain pizzalista-sivulle
    			response.sendRedirect("listaa-palkat");
    	
	        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/muutalomake.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
		HttpSession session = request.getSession();
		
		try {
		 	String strId = request.getParameter("palkkaid");
    		int palkkaid = Integer.parseInt(strId);
    		session.setAttribute("palkkaid", palkkaid);
	        String nimi = request.getParameter("nimi");
	        String strBrutto = request.getParameter("brutto");
	        double brutto = new Double(strBrutto);
	        String strNetto = request.getParameter("netto");
	        double netto = new Double(strNetto);
	     
	        Palkka palkka = new Palkka(palkkaid, nimi, brutto, netto);
	        
	        PalkkaDAO palkkadao = new PalkkaDAO();
	        
	        palkkadao.updatePalkka(palkka);
		}  catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}
		
		// uudelleenohjataan selain pizzalista-sivulle
		response.sendRedirect("listaa-palkat");
	       
	}

	
	
}
