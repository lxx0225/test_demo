package junit;

import ui_demo.entity.TestCaseSteps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
     public void  steps() throws JsonProcessingException {
         HashMap<String, TestCaseSteps> testcase=new HashMap<String, TestCaseSteps>();
         TestCaseSteps testcaseStep=new TestCaseSteps();
         List<HashMap<String,String>> steps=new ArrayList<>();

         HashMap<String, String> map=new HashMap<>();
         map.put("id", "xxxx");
         map.put("send", "xxxx");
         steps.add(map);
         steps.add(map);

         testcaseStep.setSteps(steps);
         testcase.put("search", testcaseStep);


         ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
         System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testcase));
     }

}
