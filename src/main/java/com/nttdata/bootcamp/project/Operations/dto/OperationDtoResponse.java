package com.nttdata.bootcamp.project.Operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDtoResponse
{
    private String id;
    private String operationTypeUrl;
    private String customerProductPassiveUrl;
    private double amount;
    private Date operationDate;
}
