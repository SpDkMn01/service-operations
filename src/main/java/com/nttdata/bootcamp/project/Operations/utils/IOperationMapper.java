package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.Operation;
/**
 * <h1>IOperation Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
public interface IOperationMapper
{
    OperationDtoRequest toDtoRequest(Operation operation);
    Operation toEntity(OperationDtoRequest operationDtoRequest);
    OperationDtoResponse toDtoResponse(Operation operation);
}
