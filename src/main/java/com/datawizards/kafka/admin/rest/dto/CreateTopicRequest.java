package com.datawizards.kafka.admin.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(description = "Create topic request")
public class CreateTopicRequest {
    private int partitions = 1;
    private int replicationFactor = 1;
    private String zookeeper = "127.0.0.1:2181";
    private Map<String, String> additionalConfig = new HashMap<>();

    @ApiModelProperty(value="Topic partitions", required = true)
    public int getPartitions() {
        return partitions;
    }

    @ApiModelProperty(value="Topic replication factor", required = true)
    public int getReplicationFactor() {
        return replicationFactor;
    }

    @ApiModelProperty(value="Zookeeper host e.g. localhost:2181", required = true)
    public String getZookeeper() {
        return zookeeper;
    }

    @ApiModelProperty(value="Additional Kafka config", required = false)
    public Map<String, String> getAdditionalConfig() {
        return additionalConfig;
    }
}
