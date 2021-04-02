package com.unlu.sdypp.renderizado.fachada.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RendererController {

    //FIXME: valor de retorno
    @GetMapping("/renderizarblender")
    public String blenderRenderer(@RequestParam("blender") MultipartFile blenderFile) {
        return "FIXME: conectar a servicio";
    }

    //FIXME: valor de retorno
    @GetMapping("/renderizarimagen")
    public String imageRenderer(@RequestParam("image") MultipartFile blenderFile) {
        return "FIXME: conectar a servicio";
    }
}
