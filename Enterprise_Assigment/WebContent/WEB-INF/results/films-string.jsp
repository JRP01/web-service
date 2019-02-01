<%@ page import ="java.util.List" %>
<%@ page import ="Model.Film" %>


<%
List<Film> films = (List<Film>) request.getAttribute("films");
for(int i=0; i<films.size(); i++){
	Film oneFilm = films.get(i);
	response.getWriter().println(oneFilm.toString());
	
}

%>