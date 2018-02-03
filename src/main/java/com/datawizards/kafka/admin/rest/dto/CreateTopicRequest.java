package com.datawizards.kafka.admin.rest.dto;

import lombok.Data;
import java.util.Map;

@Data
public class CreateTopicRequest {
    private int partitions;
    private int replicationFactor;
    private String zookeeper = "127.0.0.1:2181";
    private Map<String, String> additionalConfig;
}
