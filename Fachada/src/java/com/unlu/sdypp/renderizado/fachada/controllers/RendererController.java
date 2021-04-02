package com.unlu.sdypp.renderizado.fachada.controllers;

import com.unlu.sdypp.renderizado.fachada.models.BlenderJobModel;
import com.unlu.sdypp.renderizado.fachada.models.ImageJobModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RendererController {

    private static Logger logger = LoggerFactory.getLogger(RendererController.class);

    @GetMapping("/renderizarblender")
    public BlenderJobModel blenderRenderer(@RequestParam("blender") MultipartFile blenderFile) {
        //FIXME: conectar a servicio
        logger.warn("FIXME: conectar a servicio");
        return new BlenderJobModel();
    }

    @GetMapping("/renderizarimagen")
    public ImageJobModel imageRenderer(@RequestParam("image") MultipartFile blenderFile) {
        //FIXME: conectar a servicio
        logger.warn("FIXME: conectar a servicio");
        return new ImageJobModel();
    }
}
