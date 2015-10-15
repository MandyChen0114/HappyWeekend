package com.mkyong;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.mkyong.Movie.MovieResult;
import com.mkyong.Weather.Result;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String city = request.getParameter("q");
		System.out.println("city"+city);
		if (city != null) {
			try {
				Weather w = new Weather(city);
				Result result = w.getWeather();
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<style>table,th,td{border: 1px solid black;border-collapse: collapse;}");
				out.println("th, td {padding:15px;}table{width:100%}</style>");
				out.println("<table><tr><th>Parameter</th><th>Data</th></tr>");
				out.println("<tr>");
				out.println("<td>City</td>");
				out.println("<td>" + result.getCity() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Current Time</td>");
				out.println("<td>" + result.getTime() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Description</td>");
				out.println("<td>" + result.getToday() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Temprature</td>");
				out.println("<td>" + result.getTemp() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Humidity</td>");
				out.println("<td>" + result.getHumidity() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Pressure</td>");
				out.println("<td>" + result.getPressure() + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String title = request.getParameter("t");
		String year = request.getParameter("y");
		System.out.println("title"+title);
		System.out.println("year"+year);
		if (!title.equals("")) {
			Movie m = new Movie(title, year);
			try {
				MovieResult result = m.getMovie();
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<style>table,th,td{border: 1px solid black;border-collapse: collapse;}");
				out.println("th, td {padding:15px;}table{width:100%}</style>");
				out.println("<table><tr><th>Parameter</th><th>Data</th></tr>");
				out.println("<tr>");
				out.println("<td>Title</td>");
				out.println("<td>" + result.getTitle() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Year</td>");
				out.println("<td>" + result.getYear() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Country</td>");
				out.println("<td>" + result.getCountry() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Language</td>");
				out.println("<td>" + result.getLanguage() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Genre</td>");
				out.println("<td>" + result.getGenre() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Released</td>");
				out.println("<td>" + result.getReleased() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Rated</td>");
				out.println("<td>" + result.getRated() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>ImdbID</td>");
				out.println("<td>" + result.getImdbID() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Director</td>");
				out.println("<td>" + result.getDirector() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Actors</td>");
				out.println("<td>" + result.getActors() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Poster</td>");
				out.println("<td>" + result.getPoster() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Plot</td>");
				out.println("<td>" + result.getPlot() + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		if(city == null && title.equals("")){
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Hey, which movies do you want to search? Please enter movie's name and year first.");
			out.println("</body>");
			out.println("</html>");

		}
	}
}