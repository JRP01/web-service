package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.Film;
import Model.FilmDAO;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		FilmDAO fdao = new FilmDAO();
		
		 String json = request.getParameter("json");
		 String id = request.getParameter("id");
		if (json == null) {
			out.println("no paramaters were entered!!");
		}
		else if(id==null){
			out.println("no ID were entered!!");
			
		}
		else {
			//decode url
			String test =URLDecoder.decode(json);
			System.out.println(test);
			
			//covert json
			Gson gson = new Gson();
			Film update = gson.fromJson(test, Film.class);
			System.out.println(update);
			int result = Integer.parseInt(id);
			fdao.updatefilm(update, result);
		
		
		out.println("Film was Updated");
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
