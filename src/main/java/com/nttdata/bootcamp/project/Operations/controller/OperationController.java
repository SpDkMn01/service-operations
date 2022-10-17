package com.nttdata.bootcamp.project.Operations.controller;

import com.nttdata.bootcamp.project.Operations.dto.OperationDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationDtoResponse;
import com.nttdata.bootcamp.project.Operations.service.OperationService;
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
@RequestMapping("${message.path-operation}")
@RefreshScope
public class OperationController
{
    @Autowired
    private OperationService service;
    @GetMapping
    public Flux<OperationDtoResponse> getProductTypes()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Mono<OperationDtoResponse> getProductType(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<OperationDtoResponse> saveProductType(@RequestBody Mono<OperationDtoRequest> operationDtoRequest)
    {
        return service.save(operationDtoRequest);
    }
    @PutMapping("/update/{id}")
    public Mono<OperationDtoResponse> updateProductType(@RequestBody Mono<OperationDtoRequest> operationDtoRequest, @PathVariable String id)
    {
        return service.update(operationDtoRequest,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id)
    {
        return service.delete(id);
    }
}
