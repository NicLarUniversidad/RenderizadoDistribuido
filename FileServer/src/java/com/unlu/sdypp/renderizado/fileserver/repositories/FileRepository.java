package com.unlu.sdypp.renderizado.fileserver.repositories;

import com.unlu.sdypp.renderizado.fileserver.entities.FileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<FileEntity, String>, QueryByExampleExecutor<FileEntity> {
}
