package com.unlu.sdypp.renderizado.fachada.converters;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectToJsonConverter {

    public static ObjectToJsonConverter instance;

    private Gson gson;

    @Autowired
    public ObjectToJsonConverter(){
        this.gson = new Gson();
        instance = this;
    }

    public String toJson(Object object) {
        return  this.gson.toJson(object);
    }
}
