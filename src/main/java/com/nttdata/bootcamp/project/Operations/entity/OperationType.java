package com.nttdata.bootcamp.project.Operations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * <h1>OperationType Entity</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "operationType")
public class OperationType
{
    @Id
    private String id;
    private String description;
}
