package com.unlu.sdypp.renderizado.fachada.services;

import com.unlu.sdypp.renderizado.fachada.models.BlenderJobModel;
import com.unlu.sdypp.renderizado.fachada.models.ImageJobModel;
import com.unlu.sdypp.renderizado.fachada.repositories.RabbitMqConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqServiceTest {

    @Autowired
    private RabbitMqService service;

    @Autowired
    private RabbitMqConsumer<BlenderJobModel> consumer;

    @Value("${facade.queue.blender.job.request:BlenderJobRequest}")
    private String blenderJobQueue;

    @Value("${facade.queue.image.job.request:ImageJobRequest}")
    private String imageJobQueue;

    @Test
    public void publishBlenderJobTest() throws IOException, InterruptedException {
        BlenderJobModel model = new BlenderJobModel();
        model.setCreationDate(new Date());
        model.setDataBaseReference("123456");
        model.setFileName("test.txt");
        model.setFrames(1);
        service.publishBlenderJob(model);
        consumer.listen(blenderJobQueue);
        Thread.sleep(1000);
        assertThat(consumer.getMessages().size()).isGreaterThan(0);
    }

    @Test
    public void publishImageJobTest() throws IOException, InterruptedException {
        ImageJobModel model = new ImageJobModel();
        model.setCreationDate(new Date());
        model.setDataBaseReference("123456");
        model.setFileName("test.txt");
        service.publishImageJob(model);
        consumer.listen(imageJobQueue);
        Thread.sleep(1000);
        assertThat(consumer.getMessages().size()).isGreaterThan(0);
    }
}
