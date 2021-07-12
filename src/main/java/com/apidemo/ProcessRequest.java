package com.apidemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.apidemo.domain.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Urminder Deol
 *
 */
public class ProcessRequest {
    private static Map<String, Double> txnMap = new HashMap<>();

    // do a calculate operation on the json data obtained from the bench api
    public void calculateTotalAmounts(JsonObject jsonObject)
    {
        JsonArray jsonArrayList = jsonObject.getAsJsonArray("transactions");

        Gson gson = new GsonBuilder().create();
        Transaction[] txn = gson.fromJson(jsonArrayList, Transaction[].class);

        // for every transaction in the jsonArray iterate through and sum the amount for the
        // given key date. If the key/date exists, it will sum the amount. If the key/date
        // is a new date in the map, then it will insert a new key/value.
        Arrays.stream(txn).forEach(e ->
        {
            String key = e.getDate();
            Double value = Double.valueOf(e.getAmount());
            txnMap.merge(key, value, (oldVal, newVal) -> oldVal + newVal);
        });
    }

    public static Map<String, Double> getTxnMap()
    {
        return txnMap;
    }
}
