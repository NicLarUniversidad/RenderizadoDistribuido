package com.unlu.sdypp.renderizado.fachada.converters;

import static org.assertj.core.api.Assertions.assertThat;

import com.unlu.sdypp.renderizado.fachada.models.BlenderJobModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectToJsonConverterTest {

    @Test
    public void instanceTest() {
        BlenderJobModel model = new BlenderJobModel();
        String result = ObjectToJsonConverter.instance.toJson(model);
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        assertThat(result).isEqualTo(converter.toJson(model));
    }
}
