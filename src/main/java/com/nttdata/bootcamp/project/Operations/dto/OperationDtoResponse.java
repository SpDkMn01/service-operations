package com.nttdata.bootcamp.project.Operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * <h1>OperationDtoResponse</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
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
