package com.unlu.sdypp.renderizado.fachada.models;

import com.unlu.sdypp.renderizado.fachada.converters.ObjectToJsonConverter;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

import java.util.Date;

public class PartialJobEntity {

    @Id
    private String id;

    @Property("original_file_reference")
    private String originalFileReference;

    @Property("rendered_file_reference")
    private String renderedFileReference;

    private int parts;

    private int completes;

    @Property("start_date")
    private Date startDate;

    @Property("finish_date")
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
