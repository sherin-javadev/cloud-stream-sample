package com.demo.idle.threads;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableBinding(BindingInterface.class)
public class ServerMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMainApplication.class, args);

    }
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	@Bean
	public NewTopic toNewTopic() {
		return new NewTopic("topicA", 20,(short)1);
	}

	@Bean
	public NewTopic pbdScalabilityTopic() {
		return new NewTopic("topicB", 1, (short)1);
	}
	
	@StreamListener(BindingInterface.INPUT_A)
	public void topicAListener(KStream<String,String> input){
		input.foreach(new ForeachAction<String, String>() {
		    public void apply(String key, String value) {
		        System.out.println(key + ": " + value);
		    }
		 });
	}
	
	@StreamListener(BindingInterface.INPUT_B)
	public void topicBListener(KStream<String,String> input){
		input.foreach(new ForeachAction<String, String>() {
		    public void apply(String key, String value) {
		        System.out.println(key + ": " + value);
		    }
		 });
	}
	

}
