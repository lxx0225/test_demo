package junit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class User {
    public int age;
    public String name;

    @Test
    void writeJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("demo.json"),this);
    }
    @Test
    public  void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        User user = mapper.readValue(new File("demo.json"), User.class);
        System.out.println(user.name);
    }
}
