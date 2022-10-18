package com.nttdata.bootcamp.project.Operations.repository;

import com.nttdata.bootcamp.project.Operations.entity.Operation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * <h1>IOperation Repository</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Repository
public interface IOperationRepository extends ReactiveMongoRepository<Operation, String> {
}
