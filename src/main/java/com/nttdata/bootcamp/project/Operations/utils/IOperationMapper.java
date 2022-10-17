package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.Operation;
import com.nttdata.bootcamp.project.Operations.entity.OperationType;

public interface IOperationMapper
{
    OperationDtoRequest toDtoRequest(Operation operation);
    Operation toEntity(OperationDtoRequest operationDtoRequest);
    OperationDtoResponse toDtoResponse(Operation operation);
}
