package Controller;

import java.util.ArrayList;

import java.net.URLDecoder;
import java.net.URLEncoder;
import com.google.gson.Gson;

import Model.Film;
import Model.FilmDAO;

public class mainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilmDAO fdao = new FilmDAO();
		//Film insert = new Film(11311, "Test1", 1996, "Test2", "Test3", "updated");
		ArrayList<Film> films = fdao.getAllFilms();
		//for (int i=0;i<films.size(); i++) {
			//Film oneFilm = films.get(i);
			//System.out.println(oneFilm.toString());
			
		//}
		
		Gson gson = new Gson();
		String allFilmsJson = gson.toJson(films);
		System.out.println(allFilmsJson);
		//fdao.insertnewfilm(insert);
		//fdao.deletefilm(11311);
		//fdao.updatefilm(insert, 11311);
		
		//Gson gson = new Gson();
		//String json = gson.toJson(insert);
		//System.out.println(json);
		//String test =URLEncoder.encode(json);
		//System.out.println(test);
		//String test2 =URLDecoder.decode(test);
		//System.out.println(test2);
		
		//Film insert2 = gson.fromJson(test2, Film.class);
		//System.out.println(insert2);
		//fdao.insertnewfilm(insert2);
		
		

	}

}
