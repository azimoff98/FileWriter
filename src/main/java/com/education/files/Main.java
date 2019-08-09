package com.education.files;

import com.education.files.model.Error;
import com.education.files.util.ErrorModelCreator;
import com.education.files.util.ExcelFileCreator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\gurbanaz\\Desktop\\xdmx-wrong-statuses.txt";
        List<Error> errors = ErrorModelCreator.createListOfErrors(fileName);
        errors.forEach(System.out::println);
        String excelFilePath = "C:\\Users\\gurbanaz\\Desktop\\Errors3.xlsx";
        ExcelFileCreator.writeExcelFile(errors, excelFilePath);

    }

}
