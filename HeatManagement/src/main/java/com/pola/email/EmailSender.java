package com.pola.email;

import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class EmailSender {

	private static final String MY_DOMAIN = "xxxxxx";
	private static final String MY_API_KEY = "xxxxxxxx";
	
    public JsonNode sendSimpleMessage(String recipientMail, String subject, String contents) throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + MY_DOMAIN + "/messages")
                .basicAuth("api", MY_API_KEY)
                .field("from", "Excited User LemubitStudents@lemubit.com")
                .field("to", recipientMail)
                .field("subject", subject)
                .field("text", contents)
                .asJson();

        return request.getBody();
    }

}
