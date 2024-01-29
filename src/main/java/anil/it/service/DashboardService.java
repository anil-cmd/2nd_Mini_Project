package anil.it.service;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import anil.it.binding.Quote;

@Service
public class DashboardService {
	
	
	Quote[] quotes = null;
	
	public String getQuote() {
		
		String url = "https://type.fit/api/quotes";
		
		if(quotes == null) {
			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> entity = rt.getForEntity(url, String.class);
			String body = entity.getBody();
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				quotes = objectMapper.readValue(body, Quote[].class);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Random random = new Random();
		int nextInt = random.nextInt(quotes.length-1);
		Quote quote = quotes[nextInt];
		
		return quote.getText();
			
	}

}
