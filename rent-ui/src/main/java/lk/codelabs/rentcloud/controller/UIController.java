package lk.codelabs.rentcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.krishantha.rentcloud.commos.model.Customer;

import lk.codelabs.rentcloud.config.AccessToken;


@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	   
		http.authorizeRequests()
		    .antMatchers("/")
		    .permitAll()
		    .anyRequest()
		    .authenticated();
	}
	
	@RequestMapping(value="/")
	public String loadUI() {		
		return "home";
	}
	
	@RequestMapping(value="/secure")
	public String loadSecureUI() {		
		return "secure";
	}
	
	@RequestMapping(value="/customers")
	public String loadCustomers(Model model) {	
	
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.add("Authorization", AccessToken.getAccessToken());
	HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(httpHeaders);
	
	try {
	     ResponseEntity<Customer[]> responseEntity = restTemplate
	    		                                .exchange("http://localhost:8181/services/customers",
	    		                                 HttpMethod.GET,customerHttpEntity,Customer[].class);
	 	
	     System.out.println(responseEntity.getBody().length+" >>>>>>>>>");	     
	     model.addAttribute("customers", responseEntity.getBody());
	
	}catch(HttpStatusCodeException e){
		
		ResponseEntity<String> responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
				                        .body(e.getResponseBodyAsString());
		model.addAttribute("error",responseEntity);
	}
			
		return "secure";
	}


}
