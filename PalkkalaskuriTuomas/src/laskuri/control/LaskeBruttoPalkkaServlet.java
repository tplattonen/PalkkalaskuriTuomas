package laskuri.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/laske-brutto")
public class LaskeBruttoPalkkaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LaskeBruttoPalkkaServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bruttopalkkaLomake = "/view/bruttopalkkalomake.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(bruttopalkkaLomake);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// luodaan http sessio
		HttpSession session = request.getSession();
		// Lasketaan bruttopalkka
		String strTuntiPalkka = request.getParameter("tuntipalkka");
		double tuntipalkka = new Double(strTuntiPalkka);
		String strKktunnit = request.getParameter("kktunnit");
		double kktunnit = new Double(strKktunnit);
		
		double bruttopalkka = tuntipalkka * kktunnit;
		// talletetaan tieto sessioon
		session.setAttribute("bruttopalkka", bruttopalkka);
		
		
		String bruttopalkkaLomake = "/view/bruttopalkkalomake.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(bruttopalkkaLomake);
		dispatcher.forward(request, response);
	}

}
