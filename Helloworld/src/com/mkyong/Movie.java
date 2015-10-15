package com.mkyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
	private String title;
	private String year; 
	private String result;

	public Movie(String title, String year) {
		this.title = title;
		this.year = year;
//		System.out.println(title + year);
	}

	public MovieResult getMovie() throws IOException, JSONException {
		// call movie API
		String url = "http://www.omdbapi.com/?t=" + title + "&y=" + year + "&plot=full&r=json";
		url = url.replace(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		// read content in URL
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		System.out.println(response.toString());
		// The API is in the form of JSON, so parse JSON file to get info
		JSONObject object = new JSONObject(response.toString());
		String title = object.getString("Title");
		System.out.println(title);
		String year = object.getString("Year");
		String Rated = object.getString("Rated");
		String Released = object.getString("Released");
		String Genre = object.getString("Genre");
		String Director = object.getString("Director");
		String Actors = object.getString("Actors");
		String Plot = object.getString("Plot");
		String Language = object.getString("Language");
		String Country = object.getString("Country");
		String Poster = object.getString("Poster");
		String imdbID = object.getString("imdbID");
		
		// Encapsulate results into an object
		MovieResult result = new MovieResult();
		result.setActors(Actors);
		result.setCountry(Country);
		result.setDirector(Director);
		result.setGenre(Genre);
		result.setImdbID(imdbID);
		result.setLanguage(Language);
		result.setPlot(Plot);
		result.setPoster(Poster);
		result.setRated(Rated);
		result.setReleased(Released);
		result.setTitle(title);
		result.setYear(year);
		return result;

	}

	public class MovieResult {
		String title;
		String year;
		String Rated;
		String Released;
		String Genre;
		String Director;
		String Actors;
		String Plot;
		String Language;
		String Country;
		String Poster;
		String imdbID;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getRated() {
			return Rated;
		}
		public void setRated(String rated) {
			Rated = rated;
		}
		public String getReleased() {
			return Released;
		}
		public void setReleased(String released) {
			Released = released;
		}
		public String getGenre() {
			return Genre;
		}
		public void setGenre(String genre) {
			Genre = genre;
		}
		public String getDirector() {
			return Director;
		}
		public void setDirector(String director) {
			Director = director;
		}
		public String getActors() {
			return Actors;
		}
		public void setActors(String actors) {
			Actors = actors;
		}
		public String getPlot() {
			return Plot;
		}
		public void setPlot(String plot) {
			Plot = plot;
		}
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String language) {
			Language = language;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}
		public String getPoster() {
			return Poster;
		}
		public void setPoster(String poster) {
			Poster = poster;
		}
		public String getImdbID() {
			return imdbID;
		}
		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}
	}
}
