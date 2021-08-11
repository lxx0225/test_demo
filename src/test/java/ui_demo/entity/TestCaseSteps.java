package ui_demo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCaseSteps {
    public List<HashMap<String, String>> getSteps() {
        return steps;
    }

    public void setSteps(List<HashMap<String, String>> steps) {
        this.steps = steps;
    }

    List<HashMap<String,String>> steps=new ArrayList<>();

}
