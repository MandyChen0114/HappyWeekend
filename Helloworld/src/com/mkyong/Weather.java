package com.mkyong;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.google.gson.Gson;
import org.json.*;

public class Weather {
	private String country;
	private String city;
	private String temp;
	private String main;
	private String result;
	
	public Weather(String city) {
		// pass parameters
		this.city = city;
		System.out.println(city);
	}
	
	public Result getWeather() throws ParserConfigurationException, SAXException, IOException, JSONException {
		// call weather API
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+city;
		url = url.replace(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		//read content in URL	
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print result
		System.out.println(response.toString());
		
		// The API is in the form of JSON, so parse JSON file to get info
		JSONObject object = new JSONObject(response.toString());
		Double temp = object.getJSONObject("main").getDouble("temp");
		Double pressure = object.getJSONObject("main").getDouble("pressure");
		Double humidity = object.getJSONObject("main").getDouble("humidity");
		JSONArray arr = object.getJSONArray("weather");
		String today = arr.getJSONObject(0).getString("description");
		String time="";
		
		// Encapsulate results into an object
		Result result = new Result();
		result.setCity(city);
		result.setTime(time);
		result.setToday(today);
		result.setTemp(temp);
		result.setPressure(pressure);
		result.setHumidity(humidity);
		
		return result;
		
		
	}

	public class Result{
		private String city;
		private String time;
		private double temp;
		private String today;
		private double pressure;
		private double humidity;
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getTime() {
			 Date date = new Date();
		     String time=date.toString();
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		public String getToday() {
			return today;
		}
		public void setToday(String today) {
			this.today = today;
		}
		public double getPressure() {
			return pressure;
		}
		public void setPressure(double pressure) {
			this.pressure = pressure;
		}
		public double getHumidity() {
			return humidity;
		}
		public void setHumidity(double humidity) {
			this.humidity = humidity;
		}
		
	}
}


