package com.education.files.util;

import com.education.files.model.Error;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ErrorModelCreator {

    public static List<Error> createListOfErrors(String fileName){
        List<Error> errorList = new ArrayList<>();

        try(Stream<String> stream = Files.lines(Paths.get(fileName))){

            stream.forEach(
                    s -> {
                        String message = s.substring(0, s.indexOf("."));
                        String value = s.substring(s.indexOf(":") + 1, s.indexOf("=>")).trim();
                        int firstIndex = s.indexOf("\"sid\":\"");
                        String sid = s.substring(s.indexOf("\"sid\":\"") + 7, s.indexOf(",", firstIndex) - 1);
                        Error error = new Error(message, value, sid);
                        errorList.add(error);
                    }
            );


        }catch (IOException e){
            e.printStackTrace();
        }
        return errorList;
    }
}
