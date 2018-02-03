package com.datawizards.kafka.admin.rest.service;

import com.datawizards.kafka.admin.rest.dto.CreateTopicRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class KafkaAdminRESTService {
    public void createTopic(String topicName, CreateTopicRequest createTopicRequest) throws IOException {
        StringBuilder command = new StringBuilder();

        command.append("kafka-topics --create --topic ");
        command.append(topicName);
        command.append(" --partitions ");
        command.append(createTopicRequest.getPartitions());
        command.append(" --replication-factor ");
        command.append(createTopicRequest.getReplicationFactor());
        command.append(" --zookeeper ");
        command.append(createTopicRequest.getZookeeper());

        for(Map.Entry<String, String> config: createTopicRequest.getAdditionalConfig().entrySet()) {
            command.append(" --config ");
            command.append(config);
        }

        String cmd = command.toString();
        System.out.println("Executing: " + cmd);
        Runtime.getRuntime().exec(cmd);
    }
}
