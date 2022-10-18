package com.nttdata.bootcamp.project.Operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * <h1>OperationDtoRequest</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
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
