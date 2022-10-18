package com.nttdata.bootcamp.project.Operations.service;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.repository.IOperationRepository;
import com.nttdata.bootcamp.project.Operations.utils.IOperationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * <h1>Operation Service</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Service
@RequiredArgsConstructor
public class OperationService implements IOperationService<OperationDtoRequest, OperationDtoResponse> {
    @Autowired
    private final IOperationRepository repository;
    @Autowired
    private final IOperationMapper mapper;
    @Override
    public Flux<OperationDtoResponse> getAll() {
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> getById(String id)
    {
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> save(Mono<OperationDtoRequest> object)
    {
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> update(Mono<OperationDtoRequest> object, String id)
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