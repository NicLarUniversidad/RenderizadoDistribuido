package com.unlu.sdypp.renderizado.fachada.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unlu.sdypp.renderizado.fachada.converters.ObjectToJsonConverter;

import java.util.Date;

public class BlenderJobModel {

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("creation_date")
    private Date CreationDate;

    @JsonProperty("data_base_reference")
    private String dataBaseReference;

    private int frames;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public String getDataBaseReference() {
        return dataBaseReference;
    }

    public void setDataBaseReference(String dataBaseReference) {
        this.dataBaseReference = dataBaseReference;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    @Override
    public String toString() {
        return ObjectToJsonConverter.instance.toJson(this);
    }
}
