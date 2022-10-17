package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.OperationType;
import org.springframework.beans.BeanUtils;

public class OperationTypeMapper implements IOperationTypeMapper
{
    @Override
    public OperationTypeDtoRequest toDtoRequest(OperationType operationType) {
        OperationTypeDtoRequest operationTypeDtoRequest = new OperationTypeDtoRequest();
        BeanUtils.copyProperties(operationType, operationTypeDtoRequest);
        return operationTypeDtoRequest;
    }

    @Override
    public OperationType toEntity(OperationTypeDtoRequest operationTypeDtoRequest) {
        OperationType operationType = new OperationType();
        BeanUtils.copyProperties(operationTypeDtoRequest, operationType);
        return operationType;
    }

    @Override
    public OperationTypeDtoResponse toDtoResponse(OperationType operationType) {
        OperationTypeDtoResponse customerProductPassiveDtoResponse = new OperationTypeDtoResponse();
        BeanUtils.copyProperties(operationType, customerProductPassiveDtoResponse);
        return customerProductPassiveDtoResponse;
    }
}
