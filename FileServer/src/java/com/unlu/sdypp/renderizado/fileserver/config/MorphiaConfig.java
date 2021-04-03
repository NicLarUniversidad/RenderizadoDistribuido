package com.unlu.sdypp.renderizado.fileserver.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.unlu.sdypp.renderizado.fileserver.entities.FileEntity;
import com.unlu.sdypp.renderizado.fileserver.entities.JobStatusEntity;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.annotations.Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

@Configuration
public class MorphiaConfig {

    @Value("${fileserver.morphia.database.name:file_server}")
    private String databaseName;

    @Value("${fileserver.morphia.database.uri}")
    private String uri;

    /*@Bean
    public Datastore createDatastore() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.unlu.sdypp.renderizado.fileserver.entities");
        MongoClient client;
        if (uri != null) {
            client = new MongoClient(new MongoClientURI(uri));
        } else {
            client = new MongoClient();
        }
        Datastore datastore = morphia.createDatastore(client, databaseName);
        datastore.ensureIndexes();
        return datastore;
    }*/
}
