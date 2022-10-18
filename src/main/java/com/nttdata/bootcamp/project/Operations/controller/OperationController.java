package com.nttdata.bootcamp.project.Operations.controller;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.service.IOperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * <h1>Operation Controller</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-operation}")
@RefreshScope
public class OperationController
{
    @Autowired
    private IOperationService service;
    @GetMapping
    public Flux<OperationDtoResponse> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Mono<OperationDtoResponse> getById(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<OperationDtoResponse> save(@RequestBody Mono<OperationDtoRequest> requestMono)
    {
        return service.save(requestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<OperationDtoResponse> update(@RequestBody Mono<OperationDtoRequest> requestMono, @PathVariable String id)
    {
        return service.update(requestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id)
    {
        return service.delete(id);
    }
}
