package com.apidemo.model;

import com.apidemo.exception.PageNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Urminder Deol
 *
 */
public class BenchService {

    private static final String BENCH_URL = "https://resttest.bench.co/transactions/";

    public JsonObject loadBenchPage(int pageNumber) {
        try {
            URL url = new URL(BENCH_URL + Integer.valueOf(pageNumber) + ".json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int response = conn.getResponseCode();

            //Return a null JsonObject if there is no data for this 'page'
            if (response == 404)
            {
                throw new PageNotFoundException(pageNumber);
            }

            // should write better exception handling code but just didn't have enough time
            // would prefer to have my own checked exceptions
            if (response != 200)
            {
                throw new RuntimeException("HttpResponseCode: " + response);
            }
            else
            {
                String jsonDataStr = "";

                //Use a scanner to read the data from Bench Test transactions api
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    jsonDataStr += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                Gson gson = new GsonBuilder().create();
                JsonObject jsonObject = gson.fromJson(jsonDataStr, JsonObject.class);
                //main.java.com.apidemo.domain.BenchPage benchPage = gson.fromJson(jsonObject, main.java.com.apidemo.domain.BenchPage.class);

                return jsonObject;
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
