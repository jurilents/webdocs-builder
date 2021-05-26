package org.obrii.fitdocs.utils;
import net.minidev.json.*;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.File;

public class JsonParser {
    public static void testtest() throws ParseException {
        String jsonString = "D://Json//jsontest.json";
        // Кароче вверху стринга для теста

        // Внизу сам процесс получения данных из json
        // println чего-то не показывает в терминале(наверное изза того что этот метод не используеться???) потому я хз что делать

        Object obj = new JSONParser().parse(jsonString);
        JSONObject jo = (JSONObject) obj;
        String vlad = (String) jo.get("vlad");
        String dima = (String) jo.get("dima");

        // Впринципе общаяя структура парсинга пока такая дальше просто сделать словарик и закинуть туда строку эту(это слишком просто????)

        System.out.println("Hello World");
        System.out.println(vlad +" "+ dima);
    }

}
