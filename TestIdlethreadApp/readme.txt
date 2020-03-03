Boot application
   Having rest controller
      http://localhost:8080/test
         Json input(some valid json:{"test":"test"})
         
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group topic-A-InGroup  -describe
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group topic-B-InGroup  -describe

Its observed that the property concurrency has effect when using @StreamListener with Message as input

import org.springframework.messaging.Message;
@StreamListener(BindingInterface.INPUT_A)
public void topicAListener(Message input){

when using @StreamListener with KStream as input concurrency has no effect and num.stream.threads is applicable

But in our case @StreamListener with KStream as input is the requirement.