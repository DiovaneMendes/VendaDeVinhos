package br.com.vinhos.Factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ParseData {
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate stringToLocalDate(String data){
        return LocalDate.parse(data, FORMATADOR);
    }

    public static String localDateToString(LocalDate data){
        return data.format(FORMATADOR);
    }
}
