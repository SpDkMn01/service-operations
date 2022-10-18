package com.nttdata.bootcamp.project.Operations.service;

import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.repository.IOperationTypeRepository;
import com.nttdata.bootcamp.project.Operations.utils.IOperationTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * <h1>OperationType Service</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Service
@RequiredArgsConstructor
public class OperationTypeService implements IOperationTypeService<OperationTypeDtoRequest, OperationTypeDtoResponse> {
    @Autowired
    private final IOperationTypeRepository repository;
    @Autowired
    private final IOperationTypeMapper mapper;
    @Override
    public Flux<OperationTypeDtoResponse> getAll()
    {
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationTypeDtoResponse> getById(String id)
    {
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationTypeDtoResponse> save(Mono<OperationTypeDtoRequest> object)
    {
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationTypeDtoResponse> update(Mono<OperationTypeDtoRequest> object, String id)
    {
        return repository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return repository.deleteById(id);
    }
}