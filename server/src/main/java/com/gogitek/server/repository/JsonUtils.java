package com.gogitek.server.repository;


import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }

    public static <T> T stringToObject(String s, Class<T> clazz) {
        return new Gson().fromJson(s, clazz);
    }
}