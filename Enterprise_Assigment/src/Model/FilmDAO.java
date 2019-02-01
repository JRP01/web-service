package Model;
import java.util.ArrayList;
import java.sql.*;


public class FilmDAO {
	
	Film oneFilm = null;
	int Result = 1;
	Connection conn = null;
    Statement stmt = null;
	String user = "jackPhilllips";
    String password = "Password123";
    // url used to access amazon endpoint
    String url = "jdbc:mysql://enterprise.cmjoubel9ckt.us-east-2.rds.amazonaws.com:3306/EnterpriseProg";

	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for database, username, password 
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films limit 20";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public ArrayList<Film> getFilmByID(int id){
	   ArrayList<Film> selectedFilms = new ArrayList<Film>();
	   
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	selectedFilms.add(oneFilm);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return selectedFilms;
   }
   
   
  public int insertnewfilm(Film f) {
	  openConnection();
	  try {
		  String insertSQL ="INSERT INTO films (id, title, year, director, stars, review) "
		  		+ "values("+f.getId()+",'"+f.getTitle()+"',"+f.getYear()+",'"+f.getDirector()+"','"+f.getStars()+"','"+f.getReview()+"');";
		 System.out.println(insertSQL);
		  stmt.executeUpdate(insertSQL);
		  
	  }
	  catch(SQLException se) {
		  System.out.println("there was a problem");
		  System.out.println(se);
		  return 0; }
	  
	  
	  
	  
	  System.out.println("it works!!");
	  return 1;
	  
	  
	  
  }
	  
	  public int deletefilm(int id) {
		  openConnection();
		  try {
			  String deleteSQL ="DELETE FROM films WHERE id =" + id +";";
			  		
			 System.out.println(deleteSQL);
			  stmt.executeUpdate(deleteSQL);
			  
		  }
	  catch(SQLException se) {
		  System.out.println("there was a problem");
		  System.out.println(se);
		  return 0; }
	  
	  
	  
	  
	  System.out.println("it works!!");
	  return 1;
  }
	  public int updatefilm(Film f, int id) {
		  openConnection();
		  try {
			  String updateSQL = "UPDATE films SET id = "+f.getId()+", title = '"+f.getTitle()+"', year="+ f.getYear()+
					  ", director='"+f.director+"', stars='"+f.getStars()+"',review= '"+ f.getReview()+"'where id="+id+";";
			  
			 System.out.println(updateSQL);
			  stmt.executeUpdate(updateSQL);
			  
		  }
		  catch(SQLException se) {
			  System.out.println("there was a problem");
			  System.out.println(se);
			  return 0; }
		  
		  
		  
		  
		  System.out.println("it works!!");
		  return 1;
		  
		  
		  
	  }
  
  
  
  
  }
   
   
   
   

