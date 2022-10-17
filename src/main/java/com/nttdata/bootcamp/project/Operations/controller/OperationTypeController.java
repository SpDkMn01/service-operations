package com.nttdata.bootcamp.project.Operations.controller;

import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoRequest;
import com.nttdata.bootcamp.project.Operations.dto.OperationTypeDtoResponse;
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
    private OperationTypeService service;
    @GetMapping
    public Flux<OperationTypeDtoResponse> getProductTypes()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Mono<OperationTypeDtoResponse> getProductType(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<OperationTypeDtoResponse> saveProductType(@RequestBody Mono<OperationTypeDtoRequest> operationTypeDtoRequest)
    {
        return service.save(operationTypeDtoRequest);
    }
    @PutMapping("/update/{id}")
    public Mono<OperationTypeDtoResponse> updateProductType(@RequestBody Mono<OperationTypeDtoRequest> operationTypeDtoRequest, @PathVariable String id)
    {
        return service.update(operationTypeDtoRequest,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id)
    {
        return service.delete(id);
    }
}
