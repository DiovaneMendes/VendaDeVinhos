package br.com.vinhos.Factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ParseData {
    private static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate stringToLocalDate(String data){
        return LocalDate.parse(data, formatador);
    }

    public static String localDateToString(LocalDate data){
        return data.format(formatador);
    }
}
