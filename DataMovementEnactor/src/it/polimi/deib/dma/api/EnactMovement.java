package it.polimi.deib.dma.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class EnactMovement
 */
@WebServlet("/EnactMovement")
public class EnactMovement extends HttpServlet 
{
	String urlMovement="http://localhost:8089/dataEnactor/action";
	
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
		response.getWriter().println("<h1>DMA is up and running<h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("call recied redirect to script");
		
		//create the json parser
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);//to serialize arrays with only one element
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		
		//empty string. later here put the content to be sent
		String movementsEnaction = "";//container of movements  
		
        //call to movement enactors
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(urlMovement);
        
        //System.out.println(mapper.writeValueAsString(movementsEnaction));
        
        // Create some NameValuePair for HttpPost parameters
        List<NameValuePair> arguments = new ArrayList<>(3);
        arguments.add(new BasicNameValuePair("movementsEnaction", mapper.writeValueAsString(movementsEnaction)));
        try {
            post.setEntity(new UrlEncodedFormEntity(arguments));
            @SuppressWarnings("unused")
			HttpResponse responseDE = client.execute(post);//response empty

            //Print out the response of the data movement
            //System.out.println(EntityUtils.toString(responseDE.getEntity()));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
