package com.unlu.sdypp.renderizado.fileserver.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unlu.sdypp.renderizado.fileserver.converters.ObjectToJsonConverter;

import java.util.Date;

public class JobStatusModel {

    private String id;

    @JsonProperty("original_file_reference")
    private String originalFileReference;

    @JsonProperty("rendered_file_reference")
    private String renderedFileReference;

    private int parts;

    private int completes;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("finish_date")
    private Date finishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalFileReference() {
        return originalFileReference;
    }

    public void setOriginalFileReference(String originalFileReference) {
        this.originalFileReference = originalFileReference;
    }

    public String getRenderedFileReference() {
        return renderedFileReference;
    }

    public void setRenderedFileReference(String renderedFileReference) {
        this.renderedFileReference = renderedFileReference;
    }

    @Override
    public String toString() {
        return ObjectToJsonConverter.instance.toJson(this);
    }
}
