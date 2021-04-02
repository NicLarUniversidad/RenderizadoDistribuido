package com.unlu.sdypp.renderizado.fachada.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unlu.sdypp.renderizado.fachada.converters.ObjectToJsonConverter;

public class DataBaseReference {

    private String id;

    @JsonProperty("file_name")
    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return ObjectToJsonConverter.instance.toJson(this);
    }
}
