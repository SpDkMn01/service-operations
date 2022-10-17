package com.nttdata.bootcamp.project.Operations.service;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.repository.IOperationRepository;
import com.nttdata.bootcamp.project.Operations.utils.IOperationMapper;
import com.nttdata.bootcamp.project.Operations.utils.OperationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OperationService implements IOperationService<OperationDtoRequest, OperationDtoResponse> {
    @Value("${message.uri}")
    String uri;
    @Value("${message.uri2}")
    String uri2;
    @Autowired
    private final IOperationRepository repository;
    @Override
    public Flux<OperationDtoResponse> getAll() {
        IOperationMapper mapper = new OperationMapper(uri,uri2);
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> getById(String id)
    {
        IOperationMapper mapper = new OperationMapper(uri,uri2);
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> save(Mono<OperationDtoRequest> object)
    {
        IOperationMapper mapper = new OperationMapper(uri,uri2);
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<OperationDtoResponse> update(Mono<OperationDtoRequest> object, String id)
    {
        IOperationMapper mapper = new OperationMapper(uri,uri2);
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