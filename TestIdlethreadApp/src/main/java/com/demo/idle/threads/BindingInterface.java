package com.demo.idle.threads;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BindingInterface {

    String INPUT_A = "topicA-in";
    String INPUT_B = "topicB-in";

    /**
     * Ccs pay by day in.
     *
     * @return the k stream
     */
    @Input(INPUT_A)
    KStream<String,String> topicA();
    
    @Input(INPUT_B)
    KStream<String,String> topicB();
    
}