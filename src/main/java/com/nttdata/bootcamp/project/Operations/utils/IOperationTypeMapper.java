package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.OperationType;
/**
 * <h1>IOperationType Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
public interface IOperationTypeMapper
{
    OperationTypeDtoRequest toDtoRequest(OperationType operationType);
    OperationType toEntity(OperationTypeDtoRequest operationTypeDtoRequest);
    OperationTypeDtoResponse toDtoResponse(OperationType operationType);
}
