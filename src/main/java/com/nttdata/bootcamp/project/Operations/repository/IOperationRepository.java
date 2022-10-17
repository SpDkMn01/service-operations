package com.nttdata.bootcamp.project.Operations.repository;

import com.nttdata.bootcamp.project.Operations.entity.Operation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOperationRepository extends ReactiveMongoRepository<Operation, String> {
}
