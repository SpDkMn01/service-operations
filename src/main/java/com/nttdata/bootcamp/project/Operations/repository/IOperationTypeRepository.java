package com.nttdata.bootcamp.project.Operations.repository;

import com.nttdata.bootcamp.project.Operations.entity.OperationType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOperationTypeRepository extends ReactiveMongoRepository<OperationType, String> {
}
