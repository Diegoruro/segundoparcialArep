package edu.eci.arep;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import static spark.Spark.*;

public class SparkWebApp {
    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getPort());
        get("collatzsequence", (req, res) -> {
            res.type("application/json");
            return JsonParser.parseString(CollatzSequence.response(Integer.parseInt(req.queryParams("value"))));
        });

    }
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
