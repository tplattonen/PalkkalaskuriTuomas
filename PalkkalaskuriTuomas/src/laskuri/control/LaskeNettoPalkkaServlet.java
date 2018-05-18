package laskuri.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/laske-netto")
public class LaskeNettoPalkkaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LaskeNettoPalkkaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		/*String bruttopalkka = request.getParameter("bruttopalkka");
		request.setAttribute("bruttopalkka", bruttopalkka);*/
		
		String nettopalkkaLomake = "/view/nettopalkkalomake.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nettopalkkaLomake);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ker�t��n tiedot formista laskentaa varten 
		String bruttopalkka = request.getParameter("bruttopalkka");
		request.setAttribute("bruttopalkka", bruttopalkka);
		String strPalkka = request.getParameter("palkka");
		double palkka = new Double(strPalkka);
		String strVeroPro = request.getParameter("veroprosentti");
		double veroPro = new Double(strVeroPro);
		
		// saadaan kerroin nettopalkkaa varten
		double veroKerroin = 1 - veroPro;
		
		//veroton palkka
		double veroton = palkka * veroKerroin;
		
		//poistetaan alle 53-vuotiaiden el�kevakuutusmaksu ja ty�tt�myysvakuutusmaksu
		// eli 0,0635 + 0,0115 = 0,075 | 1 - 0,075 = 0,925
		double elatyotKerroin = 1 - 0.075;
		
		// t�m�n j�lkee j��v� nettopalkka
		double netto = elatyotKerroin * veroton;
		// luodaan http session ja lis�t��n nettopalkan tiedot siihen
		HttpSession session = request.getSession();
		session.setAttribute("netto", netto);
		
		String nettopalkkaLomake = "/view/nettopalkkalomake.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nettopalkkaLomake);
		dispatcher.forward(request, response);
		
	}

}
