package com.example.autoconfiguration.component;


import java.time.ZonedDateTime;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "admin")
public class CustomActuatorEndpoint {


    @ReadOperation
    public CustomActuatorResponse readResponse() {
        return new CustomActuatorResponse(Operation.READ.name(), ZonedDateTime.now());
    }

    @WriteOperation
    public CustomActuatorResponse writeResponse() {
        return new CustomActuatorResponse(Operation.WRITE.name(), ZonedDateTime.now());
    }

    @DeleteOperation
    public CustomActuatorResponse deleteResponse() {
        return new CustomActuatorResponse(Operation.DELETE.name(), ZonedDateTime.now());
    }


}
