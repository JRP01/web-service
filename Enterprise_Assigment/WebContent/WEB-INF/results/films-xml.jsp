<%@ page import="java.util.List"%>
<%@ page import="javax.xml.bind.JAXBContext"%>
<%@ page import="javax.xml.bind.JAXBException"%>
<%@ page import="javax.xml.bind.Marshaller"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.FilmList"%>
<%@ page trimDirectiveWhitespaces ="true" %>

<%
FilmList films = new FilmList ((List<Film>) request.getAttribute("films")); 
try{
	System.out.println("1");
	JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
	System.out.println("2");
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	System.out.println("3");
	jaxbMarshaller.marshal(films, out);
	System.out.println("4");
	
}
catch(JAXBException e){e.printStackTrace();}

%>
