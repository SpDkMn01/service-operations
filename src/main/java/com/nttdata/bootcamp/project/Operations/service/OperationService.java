package com.nttdata.bootcamp.project.Operations.service;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.repository.IOperationRepository;
import com.nttdata.bootcamp.project.Operations.repository.IOperationTypeRepository;
import com.nttdata.bootcamp.project.Operations.utils.IOperationMapper;
import com.nttdata.bootcamp.project.Operations.utils.IOperationTypeMapper;
import com.nttdata.bootcamp.project.Operations.utils.OperationMapper;
import com.nttdata.bootcamp.project.Operations.utils.OperationTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OperationService
        implements IOperationService<OperationDtoRequest, OperationDtoResponse> {
    @Autowired
    private final IOperationRepository operationRepository;
    @Override
    public Flux<OperationDtoResponse> getAll() {
        IOperationMapper mapper = new OperationMapper();
        return operationRepository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> getById(String id)
    {
        IOperationMapper mapper = new OperationMapper();
        return operationRepository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> save(Mono<OperationDtoRequest> object)
    {
        IOperationMapper mapper = new OperationMapper();
        return object.map(mapper::toEntity)
                .flatMap(operationRepository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> update(Mono<OperationDtoRequest> object, String id)
    {
        IOperationMapper mapper = new OperationMapper();
        return operationRepository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(operationRepository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return operationRepository.deleteById(id);
    }
}