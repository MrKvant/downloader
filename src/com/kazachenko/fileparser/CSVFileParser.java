package com.kazachenko.fileparser;

import com.kazachenko.model.Link;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/13/2017.
 */
public class CSVFileParser implements FileParser {
    public List<Link> parseLinks(File file) {
        List<Link> links = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = " ";

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR:File not found.");
            System.exit(0);
        }
        try {
            while ((line = br.readLine()) != null) {
                String[] str = line.split(csvSplitBy);
                links.add(new Link(str[0],str[1]));
            }
        } catch (IOException e) {
            System.out.println("ERROR: Incorrect file syntax or file damaged.");
            System.exit(0);
        }

        return links;
    }
}
