package it.polimi.deib.dma.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class EnactMovement
 */
@WebServlet("/EnactMovement")
public class EnactMovement extends HttpServlet 
{
	String urlMovement="http://mysql-query-executor:8080/api/switchToReplica";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnactMovement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("call received");
		response.getWriter().println("<h1>DMA is up and running<h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Call received redirect to script");
		
//		//create the json parser
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);//to serialize arrays with only one element
//		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//
//		response.getWriter().println("proxy is called");
//		response.setStatus(HttpStatus.SC_OK);
//		
//        //call to movement enactors
//        HttpClient client = HttpClientBuilder.create().build();
//        
//        HttpGet get = new HttpGet(urlMovement);
//        
//        HttpResponse responseSwitcher = client.execute(get);
//
//    	System.out.println("Response Code : " 
//                    + responseSwitcher.getStatusLine().getStatusCode());
//        
//    	BufferedReader rd = new BufferedReader(
//    			new InputStreamReader(responseSwitcher.getEntity().getContent()));
//
//    		StringBuffer result = new StringBuffer();
//    		String line = "";
//    		while ((line = rd.readLine()) != null) {
//    			result.append(line);
//    		}
//    		
//    	System.out.println("responce from switcher: " + result);
        

	}

}
