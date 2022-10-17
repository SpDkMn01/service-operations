package com.nttdata.bootcamp.project.Operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDtoRequest
{
    private String operationTypeId;
    private String customerProductPassiveId;
    private double amount;
    private Date operationDate;
}
