package com.nttdata.bootcamp.project.Operations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
/**
 * <h1>Operation Entity</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "operation")
public class Operation
{
    @Id
    private String id;
    private String operationTypeId;
    private String customerProductPassiveId;
    private double amount;
    private Date operationDate;
}
