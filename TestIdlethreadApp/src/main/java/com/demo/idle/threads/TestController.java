package com.demo.idle.threads;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private KafkaOperations kafkaOperations;

	@PostMapping(value = "test", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	public String test(@RequestBody String test){
		System.out.println(test);
		kafkaOperations.send("topicA",test);
		kafkaOperations.send("topicB",test);
		return test+Math.random();
	}
}
