package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.Operation;
import com.nttdata.bootcamp.project.Operations.entity.OperationType;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
@AllArgsConstructor
public class OperationMapper implements IOperationMapper
{
    private String uri;
    private String uri2;
    @Override
    public OperationDtoRequest toDtoRequest(Operation operation) {
        OperationDtoRequest operationDtoRequest = new OperationDtoRequest();
        BeanUtils.copyProperties(operation, operationDtoRequest);
        return operationDtoRequest;
    }

    @Override
    public Operation toEntity(OperationDtoRequest operationDtoRequest) {
        Operation operation = new Operation();
        BeanUtils.copyProperties(operationDtoRequest, operation);
        return operation;
    }

    @Override
    public OperationDtoResponse toDtoResponse(Operation operation) {
        OperationDtoResponse operationDtoResponse = new OperationDtoResponse();
        BeanUtils.copyProperties(operation, operationDtoResponse);
        operationDtoResponse.setOperationTypeUrl(uri + operation.getOperationTypeId());
        operationDtoResponse.setCustomerProductPassiveUrl(uri2 + operation.getCustomerProductPassiveId());
        return operationDtoResponse;
    }
}
