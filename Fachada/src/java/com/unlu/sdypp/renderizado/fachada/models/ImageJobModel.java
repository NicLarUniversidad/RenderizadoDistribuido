package com.unlu.sdypp.renderizado.fachada.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unlu.sdypp.renderizado.fachada.converters.ObjectToJsonConverter;

import java.util.Date;

public class ImageJobModel {

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("data_base_reference")
    private String dataBaseReference;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDataBaseReference() {
        return dataBaseReference;
    }

    public void setDataBaseReference(String dataBaseReference) {
        this.dataBaseReference = dataBaseReference;
    }

    @Override
    public String toString() {
        return ObjectToJsonConverter.instance.toJson(this);
    }
}
