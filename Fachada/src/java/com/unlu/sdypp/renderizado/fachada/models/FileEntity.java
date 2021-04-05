package com.unlu.sdypp.renderizado.fachada.models;


import com.unlu.sdypp.renderizado.fachada.converters.ObjectToJsonConverter;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

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
