package com.apidemo;

import com.google.gson.JsonObject;
import com.apidemo.exception.PageNotFoundException;
import com.apidemo.model.BenchService;

import java.util.Map;


/**
 * @author Urminder Deol
 * Calculates running daily balances and prints them to the console.
 */

public class RestApiClient {
    public static void main(String[] args) {
        try
        {
            BenchService service = new BenchService();
            ProcessRequest processRequest = new ProcessRequest();


            int pageNumber = 1;
            JsonObject benchPage = service.loadBenchPage(pageNumber);
            do
            {
                try {
                    processRequest.calculateTotalAmounts(benchPage);
                    pageNumber++;
                    benchPage = service.loadBenchPage(pageNumber);}
                catch (PageNotFoundException e)
                {
                    break;
                }
                catch (RuntimeException e)
                {
                    break;
                }
            } while (benchPage != null);

            Map<String, Double> totalAmounts = processRequest.getTxnMap();
            totalAmounts.forEach(
                    (date, total) ->
                    {
                        double d = total.doubleValue();
                        System.out.printf("%s    %s%n", date, String.format("%.2f",d));
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
