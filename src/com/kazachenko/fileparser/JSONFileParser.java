package com.kazachenko.fileparser;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kazachenko.model.Link;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/13/2017.
 */
public class JSONFileParser implements FileParser {

    public List<Link> parseLinks(File file) {
        List<Link> links = new ArrayList<>();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR:File not found.");
            System.exit(0);
        }

        Gson gson = new Gson();
        try {
            links = gson.fromJson(reader, new TypeToken<List<Link>>() {}.getType());
        } catch (JsonIOException|JsonSyntaxException e) {
            System.out.println("ERROR: Incorrect file syntax or file damaged.");
            System.exit(0);
        }

        return links;
    }
}