package com.datawizards.kafka.admin.rest.service;

import com.datawizards.kafka.admin.rest.dto.CreateTopicRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaAdminRESTService {
    public void createTopic(String topicName, CreateTopicRequest createTopicRequest) throws IOException {
        String command = "kafka-topics --create --topic " + topicName
                + " --partitions " + createTopicRequest.getPartitions()
                + " --replication-factor " + createTopicRequest.getReplicationFactor()
                + " --zookeeper " + createTopicRequest.getZookeeper();

        System.out.println("Executing: " + command);
        Runtime.getRuntime().exec(command);
    }
}
