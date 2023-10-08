package com.example.autoconfiguration.component;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomActuatorResponse {

    private String operationName;
    private ZonedDateTime operationTime;
}
