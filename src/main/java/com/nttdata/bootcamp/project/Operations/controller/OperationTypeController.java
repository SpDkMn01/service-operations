package com.nttdata.bootcamp.project.Operations.controller;

import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
import com.nttdata.bootcamp.project.Operations.service.IOperationTypeService;
import com.nttdata.bootcamp.project.Operations.service.OperationTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-operationType}")
@RefreshScope
public class OperationTypeController
{
    @Autowired
    private IOperationTypeService service;
    @GetMapping
    public Flux<OperationTypeDtoResponse> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Mono<OperationTypeDtoResponse> getById(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<OperationTypeDtoResponse> save(@RequestBody Mono<OperationTypeDtoRequest> requestMono)
    {
        return service.save(requestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<OperationTypeDtoResponse> update(@RequestBody Mono<OperationTypeDtoRequest> requestMono, @PathVariable String id)
    {
        return service.update(requestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id)
    {
        return service.delete(id);
    }
}
