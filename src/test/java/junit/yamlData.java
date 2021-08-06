package junit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class yamlData {
    @Test
   public void readFile(){
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/app/TestStock.yaml"));

    }
    @Test
    void writeJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("demo.json"),User.class);
    }

     @Test
    public void testStep(){
         HashMap <String , ArrayList> steps = new HashMap<>();
     }
}
