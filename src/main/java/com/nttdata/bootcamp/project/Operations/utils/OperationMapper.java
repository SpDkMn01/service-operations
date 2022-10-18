package com.nttdata.bootcamp.project.Operations.utils;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.entity.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * <h1>Operation Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@RequiredArgsConstructor
@Component
public class OperationMapper implements IOperationMapper
{
    @Value("${message.uri}")
    private String uri;
    @Value("${message.uri2}")
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
