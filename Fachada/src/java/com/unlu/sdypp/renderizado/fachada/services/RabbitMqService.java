package com.unlu.sdypp.renderizado.fachada.services;

import com.unlu.sdypp.renderizado.fachada.models.BlenderJobModel;
import com.unlu.sdypp.renderizado.fachada.models.ImageJobModel;
import com.unlu.sdypp.renderizado.fachada.repositories.RabbitMqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMqService {

    @Value("${facade.queue.blender.job.request:BlenderJobRequest}")
    private String blenderJobRequest;

    @Value("${facade.queue.image.job.request:ImageJobRequest}")
    private String imageJobRequest;

    private RabbitMqRepository rabbitMqRepository;

    @Autowired
    public RabbitMqService(RabbitMqRepository rabbitMqRepository) {
        this.rabbitMqRepository = rabbitMqRepository;
    }

    public void publishBlenderJob(BlenderJobModel blenderJobModel) throws IOException {
        rabbitMqRepository.publish(blenderJobModel.toString(), blenderJobRequest);
    }

    public void publishImageJob(ImageJobModel imageJobModel) throws IOException {
        rabbitMqRepository.publish(imageJobModel.toString(), imageJobRequest);
    }

}
