import generators.BracesGenerator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BracesGenerator bracesGenerator = new BracesGenerator();
        List<String> values = bracesGenerator.generate(8);
        System.out.println(values);
        System.out.println(values.size());
    }



}


