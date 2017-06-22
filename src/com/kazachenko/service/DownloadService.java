package com.kazachenko.service;

import com.google.common.io.ByteStreams;
import com.kazachenko.Config;
import com.kazachenko.LoadThread;
import com.kazachenko.model.Link;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 6/16/2017.
 */
public class DownloadService {

    public static Integer downloadFile(Link link) {
        Config config = Config.getConfig();
        HttpURLConnection con = null;
        Integer countBytes;
        try {
            URL url = new URL(link.getUrl());
            con = (HttpURLConnection) url.openConnection();

        } catch (IOException e) {
            System.out.println("ERROR: Bad link: " + link.getUrl());
            return null;
        }
        countBytes = con.getContentLength();
        try {
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                FileOutputStream out = new FileOutputStream(config.getSavingPlace() + "\\" + link.getSavingName());
                InputStream in = con.getInputStream();
                ByteStreams.copy(in, out);
                in.close();
                out.close();
            } else {
                System.out.println("ERROR: Request error (response code: " + responseCode + ").");
                return null;
            }
        } catch (IOException e) {
            System.out.println("ERROR: File can not write.");
            return null;
        }
        return countBytes;
    }

    public static void downloadFiles(List<Link> links) {

        Config conf = Config.getConfig();
        LoadThread.setLinks(links);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < conf.getCountThreads(); i++)
            threads.add(new Thread(new LoadThread()));


        for (int i = 0; i < conf.getCountThreads(); i++)
            threads.get(i).start();

        for (int i = 0; i < conf.getCountThreads(); i++)
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                System.out.println("ERROR: Unknown error.");
                System.exit(0);
            }

    }
}
