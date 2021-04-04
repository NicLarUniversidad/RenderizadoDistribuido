package com.unlu.sdypp.renderizado.fileserver.repositories;

import com.unlu.sdypp.renderizado.fileserver.entities.PartialJobStatusEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PartialJobStatusRepository extends MongoRepository<PartialJobStatusEntity, String>,
        QueryByExampleExecutor<PartialJobStatusEntity> {

    List<PartialJobStatusEntity> findByJobReference(String jobReference);
}
