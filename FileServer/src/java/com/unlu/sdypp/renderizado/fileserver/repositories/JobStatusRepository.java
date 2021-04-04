package com.unlu.sdypp.renderizado.fileserver.repositories;

import com.unlu.sdypp.renderizado.fileserver.entities.JobStatusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobStatusRepository extends MongoRepository<JobStatusEntity, String>,
        QueryByExampleExecutor<JobStatusEntity> {

    List<JobStatusEntity> findByOriginalFileReference(String originalFileReference);
}
