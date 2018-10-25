package com.kozitski.task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {

        // creating object first yaml data by jackson
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {

            Student testObject = mapper.readValue(new File("src/main/resources/data/student.yml"), Student.class);
            System.out.println(testObject);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


// yaml documentation
//  https://bitbucket.org/asomov/snakeyaml/wiki/Documentation#markdown-header-loading-yaml
