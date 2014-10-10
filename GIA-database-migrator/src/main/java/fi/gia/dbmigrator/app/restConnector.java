package fi.gia.dbmigrator.app;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;






public class restConnector {
	
private static final Logger LOGGER = LoggerFactory.getLogger(restConnector.class);
	
	private static final restConnector INSTANCE = new restConnector();
  
	
	public static restConnector getInstance() {
		return restConnector.INSTANCE;
	}
	
	private restConnector(){		
	}
	
	private static String user = "samu_admin";
	private static String pwd = "teiqu6beE!";
	private static String pwd2 = "575756156550AD51F42B73951B5B73B0";
	
	public static String encode(String user, String pwd) { 
        final String credentials =  user+":"+pwd; 
        BASE64Encoder encoder = new sun.misc.BASE64Encoder(); 
        return encoder.encode(credentials.getBytes()); 
} 
	
	
	//Open REST connection
	public static void init() {
		restConnector.LOGGER.info("Starting REST connection...");

		
		try {
			
			Client client = Client.create();
			client.addFilter(new LoggingFilter(System.out));
			
			WebResource webResource = client.resource("https://demo.globalintelligence.com/development/");
			
			String url = "activepersonal";
			
		
		
			
			
	 
			ClientResponse response = webResource
						.path("api/alerts/")
						.queryParam("filter", ""+url)						
						.header("Authorization", "Basic "+encode(user, pwd))
						.header("x-api-version", "1")		
						.accept("Application/json")
					 	.get(ClientResponse.class);
			
	 
			if (response.getStatus() != 200) {
			   
			   /*restConnector.LOGGER.info("Failed : HTTP error code : " + response.getStatus());*/
			}else{
				restConnector.LOGGER.info("REST connartingection STARTED.");
			}
	 
			
			String output = response.getEntity(String.class);		
			
System.out.println(output);
			
			ObjectMapper mapper = new ObjectMapper();			
			 mapper.setPropertyNamingStrategy(new MyNameStrategy());
			 
			 List<Alert> alert = mapper.readValue(output, new TypeReference<List<Alert>>(){});
			
		//	AlertList alert = mapper.readValue(output, Alert.class);
			restConnector.LOGGER.info("Java Object created from JSON String ");
			restConnector.LOGGER.info("JSON String : " + output);
			restConnector.LOGGER.info("Java Object : \n" + alert.toString());
			
			//System.out.println(alert.get(0).getHeader());



		  } catch (Exception e) {
	 
			e.printStackTrace();
			//restConnector.LOGGER.info("REST connartingection FAILED.");
	 
		  }
		
		
	}
	
	public void close() {
		
	}
	
	
	

}
