package com.kazachenko;

import com.kazachenko.service.DownloadService;
import com.kazachenko.service.LinksService;
import com.kazachenko.model.Link;

import java.util.*;

public class Downloader {

    public static void main(String[] args) throws Exception {

        Config conf = Config.createConfig(args);
        List<Link> links = new ArrayList<>();

        System.out.println("Threads:  " + conf.getCountThreads());
        System.out.println("Saved to: " + conf.getSavingPlace());
        System.out.println("Downloading...");

        if (conf.getLinksFile() != null)
            links = LinksService.getLinks(conf.getLinksFile());
         else{
            Link oneLink = new Link(conf.getUrl(), conf.getSavingName());
            links.add(oneLink);
        }

        long startTime = System.currentTimeMillis();
        DownloadService.downloadFiles(links);
        long endTime = System.currentTimeMillis();

        Float totalTime = ((float)(endTime - startTime))/1000;

        System.out.println("---------------------------");
        System.out.println("Download: " + LoadThread.getCountDownloadFiles() + "/" + links.size() + " files.");
        System.out.println("Download: " + ((float)LoadThread.getCountDownloadBytes())/1024/1024 + " Mb.");
        System.out.println("Total time: " + totalTime + " seconds.");
    }
}