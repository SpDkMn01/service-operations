package com.nttdata.bootcamp.project.Operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDtoResponse
{
    private String id;
    private String operationTypeUrl;
    private String customerProductPassiveUrl;
    private double mount;
}
