package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.OperationType;

public interface IOperationTypeMapper
{
    OperationTypeDtoRequest toDtoRequest(OperationType operationType);
    OperationType toEntity(OperationTypeDtoRequest operationTypeDtoRequest);
    OperationTypeDtoResponse toDtoResponse(OperationType operationType);
}
