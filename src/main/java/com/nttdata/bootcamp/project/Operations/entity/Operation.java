package com.nttdata.bootcamp.project.Operations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private double mount;
}
