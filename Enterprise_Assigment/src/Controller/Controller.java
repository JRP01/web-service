package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.Film;
import Model.FilmDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
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
				PrintWriter out = response.getWriter();
				FilmDAO fdao = new FilmDAO();
				ArrayList<Film> films = fdao.getAllFilms();
				System.out.println("Test: " + films.toString());
				
				
				request.setAttribute("films", films);
				String format = request.getParameter("format");
				String test = request.getParameter("test");
				System.out.println(test);
				if (test == null) {
					System.out.println("no film was inputed");
				}else {
				int result = Integer.parseInt(test);
				ArrayList<Film> selectedfilm = fdao.getFilmByID(result);
				System.out.println(selectedfilm);
				}
				String outputPage;
				if("xml".equals(format)) {
					response.setContentType("text/xml");
					outputPage = "/WEB-INF/results/films-xml.jsp";
				}else if ("json".equals(format)) {
					response.setContentType("application/json");
					outputPage = "/WEB-INF/results/films-json.jsp";
				} else {
					response.setContentType("text/plain");
					outputPage = "/WEB-INF/results/films-string.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
				dispatcher.include(request, response);
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
