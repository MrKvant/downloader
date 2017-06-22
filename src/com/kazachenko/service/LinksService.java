package com.kazachenko.service;

import com.kazachenko.fileparser.CSVFileParser;
import com.kazachenko.fileparser.FileParser;
import com.kazachenko.fileparser.JSONFileParser;
import com.kazachenko.fileparser.XMLFileParser;
import com.kazachenko.model.Link;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 6/17/2017.
 */
public class LinksService {

    private static final String FILE_CSV = "csv";
    private static final String FILE_JSON = "json";
    private static final String FILE_XML = "xml";

    private static FileParser getParser(String fileName) {

        FileParser fileParser = null;
        String ext = getFileExtension(fileName);

        if (ext == null) {
            System.out.println("ERROR: Links file not found.");
            System.exit(0);
        }
        switch (ext){
            case FILE_CSV: fileParser = new CSVFileParser(); break;
            case FILE_JSON: fileParser = new JSONFileParser(); break;
            case FILE_XML: fileParser = new XMLFileParser(); break;
        }
        return fileParser;
    }

    public static List<Link> getLinks(String filePath){
        return getParser(filePath).parseLinks(new File(filePath));
    }

    private static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? null : fileName.substring(index + 1).toLowerCase();
    }
}
