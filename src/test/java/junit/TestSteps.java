package junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestSteps
{
    public HashMap<String, ArrayList> getSteps() {
        return steps;
    }

    public void setSteps(HashMap<String, ArrayList> steps) {
        this.steps = steps;
    }

    HashMap <String ,ArrayList> steps = new HashMap<>();




}
