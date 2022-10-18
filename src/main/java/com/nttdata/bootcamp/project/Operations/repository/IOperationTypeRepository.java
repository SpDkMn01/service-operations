package com.nttdata.bootcamp.project.Operations.repository;

import com.nttdata.bootcamp.project.Operations.entity.OperationType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * <h1>IOperationType Repository</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Repository
public interface IOperationTypeRepository extends ReactiveMongoRepository<OperationType, String> {
}
