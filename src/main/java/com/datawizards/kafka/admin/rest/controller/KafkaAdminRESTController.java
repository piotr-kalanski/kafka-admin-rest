package com.datawizards.kafka.admin.rest.controller;

import com.datawizards.kafka.admin.rest.dto.CreateTopicRequest;
import com.datawizards.kafka.admin.rest.service.KafkaAdminRESTService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class KafkaAdminRESTController {

    @Autowired
    private KafkaAdminRESTService kafkaAdminRESTService;

    @ApiOperation(value = "createTopic", nickname = "createTopic", notes = "Create Kafka topic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(
            path = "/v1/topic/{topic}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    public void createTopic(@PathVariable("topic") String topicName, @RequestBody CreateTopicRequest createTopicRequest) throws IOException {
        kafkaAdminRESTService.createTopic(topicName, createTopicRequest);
    }
}
