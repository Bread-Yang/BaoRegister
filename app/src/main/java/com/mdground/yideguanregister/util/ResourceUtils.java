package com.mdground.yideguanregister.util;

import android.content.Context;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by yoghourt on 12/3/15.
 */
public class ResourceUtils {

    public static HashMap<String, String> getHashMapResource(Context context, int hashMapResId) {
        String[] stringArray = context.getResources()
                .getStringArray(hashMapResId);
        HashMap<String, String> outputMap = new HashMap<String, String>();
        for (String entry : stringArray) {
            String[] splitResult = entry.split("\\|", 2);
            outputMap.put(splitResult[0], splitResult[1]);
        }
        return outputMap;
    }

    public static TreeMap<String, String> getTreeMapResource(Context context, int hashMapResId) {
        String[] stringArray = context.getResources()
                .getStringArray(hashMapResId);
        TreeMap<String, String> outputMap = new TreeMap<String, String>();
        for (String entry : stringArray) {
            String[] splitResult = entry.split("\\|", 2);
            outputMap.put(splitResult[0], splitResult[1]);
        }
        return outputMap;
    }

    public static HashMap<String, String> getMapCombineByTwoArray(Context context, int keysResId, int valuesResId) {
        String[] keys = context.getResources().getStringArray(keysResId);
        String[] values = context.getResources().getStringArray(valuesResId);

        HashMap<String, String> returnMap = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            returnMap.put(keys[i], values[i]);
        }
        return returnMap;
    }
}
