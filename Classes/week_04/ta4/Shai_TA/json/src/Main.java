import com.google.gson.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import static java.lang.StrictMath.max;

public class Main {
    /**
     * Prints the JSON object
     * @param j_obj The JSON object
     */
    public static void printJson(JsonObject j_obj) {
        printJson(j_obj, 15);
    }

    /**
     * Prints the JSON object
     * @param j_obj_str The JSON string
     */
    public static void printJson(String j_obj_str) {
        JsonObject j_obj = JsonParser.parseString(j_obj_str).getAsJsonObject();
        printJson(j_obj, -1);
    }

    /**
     * Prints the JSON object
     * @param j_obj The JSON object
     * @param padd Amount of padding for the keys
     */
    public static void printJson(JsonObject j_obj, int padd) {
        if (padd < 0) {
            for (String k : j_obj.keySet())
                padd = max(padd, k.length());
        }
        for (Map.Entry<String, JsonElement> entry : j_obj.entrySet()) {
            System.out.println(String.format("%" + (-padd) + "s:\t%s", entry.getKey(), entry.getValue()));
        }
    }


    public static void main(String[] args) {
        final String json_path = "src/example.json";

        // Reading json object
//        JsonObject json_obj = new JsonObject();
//        try {
//            String json_str = new String(
//                    Files.readAllBytes(Paths.get(json_path))
//            );
//            json_obj = JsonParser.parseString(json_str).getAsJsonObject();
//            System.out.println(json_obj.toString());
//
//            printJson(json_obj);
//
//            System.out.println(json_obj.get("nick_name"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Create Json from ground-up
//        JsonObject my_json = new JsonObject();
//        my_json.addProperty("title", "Dr.");
//        my_json.addProperty("name", "Who");
//        my_json.addProperty("type", "TimeLord");
//        my_json.addProperty("doctor_num", 9);
//        my_json.addProperty("heart_num", 2);
//
//        JsonArray jsonArray = new JsonArray();
//        jsonArray.add("Rose Tyler");
//        jsonArray.add("Adam Mitchell");
//        jsonArray.add("Captain Jack Harkness");
//
//        my_json.add("companions", jsonArray);
//        printJson(my_json, -1);

       //Create Json from Object
        Gson gson = new Gson();
//        DrWho drwho = new DrWho();
//        String dr_json_str = gson.toJson(drwho);
//        printJson(dr_json_str);
//
//        // Save the object to a file
        Path file = Paths.get("my_drwho.json");
//        try {
//            Files.write(file, Arrays.asList(dr_json_str), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Load the json to an object
        try {
            String json_str = new String(Files.readAllBytes(file));
            DrWho loaded_dr = gson.fromJson(json_str, DrWho.class);

            System.out.println(loaded_dr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
