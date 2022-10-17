package com.nttdata.bootcamp.project.Operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDtoRequest
{
    private String id;
    private String operationTypeId;
    private String customerProductPassiveId;
    private double mount;
}
