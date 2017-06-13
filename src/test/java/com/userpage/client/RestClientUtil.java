package com.userpage.client;

import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.userpage.entity.User;

public class RestClientUtil {
    
    public void addUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/user";
	    User objUser = new User();
	    objUser.setName("Spring");
	    objUser.setAddress("Spring");
	    objUser.setDob(new Date());
        HttpEntity<User> requestEntity = new HttpEntity<User>(objUser, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }    
}
