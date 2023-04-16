package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Application;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vueFinale = "ListSoftware.jsp";
		
		vueFinale = doAction(request);
		
		request.getRequestDispatcher(vueFinale).forward(request, response);
	}

	private String doAction(HttpServletRequest request) {
		String vueFinale = "ListSoftware.jsp";
		
		
		String action = request.getParameter("action");


		if ("addSoft".equals(action)) {

		    String texte = request.getParameter("soft_texte");
		    String ver = request.getParameter("soft_ver");
		    String lic = request.getParameter("soft_lic");
		    if(!"".equals(texte)) {
		    	Application.getInstance().addSoftware(texte, ver, lic);;
		    }

		    vueFinale = "ListSoftware.jsp";
		}
		
		//Action Delete
		if ("Delete".equals(action)) {
			String texte = request.getParameter("soft_delete");
			System.out.println(true);
			Application.getInstance().deleteSoftware(texte);
					
		    vueFinale = "ListSoftware.jsp";
		}
		
		if ( "updateList".equals( action ) ){
		    String texte = request.getParameter("soft_texte");
		    String ver = request.getParameter("soft_ver");
		    String lic = request.getParameter("soft_lic");
		    
		    Application.getInstance().getSoftware(texte).setVersion(ver);
		    Application.getInstance().getSoftware(texte).setLicence(lic);
		    
		    vueFinale = "ListSoftware.jsp";
		}
		
		
		return vueFinale;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
