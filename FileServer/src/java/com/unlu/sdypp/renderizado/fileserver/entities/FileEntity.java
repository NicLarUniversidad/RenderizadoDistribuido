package com.unlu.sdypp.renderizado.fileserver.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unlu.sdypp.renderizado.fileserver.converters.ObjectToJsonConverter;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

@Entity("File")
public class FileEntity {

    @Id
    private String id;

    @Property("file_name")
    private String fileName;

    private int frames;

    private String content;

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

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ObjectToJsonConverter.instance.toJson(this);
    }
}
