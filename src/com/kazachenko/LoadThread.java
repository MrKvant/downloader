package com.kazachenko;

import com.kazachenko.model.Link;
import com.kazachenko.service.DownloadService;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by admin on 6/20/2017.
 */
public class LoadThread implements Runnable {

    private static Queue<Link> links;

    private static volatile int countDownloadFiles = 0;
    private static volatile int countDownloadBytes = 0;

    public void run() {
        Integer bytes;
        Link link;
        while (true) {
            synchronized (links) {
                if (!links.isEmpty())
                    link = links.poll();
                else return;
            }
            if ((bytes = DownloadService.downloadFile(link)) != null) {
                countDownloadBytes += bytes;
                ++countDownloadFiles;
            }
        }
    }

    public static int getCountDownloadFiles() {
        return countDownloadFiles;
    }

    public static int getCountDownloadBytes() {
        return countDownloadBytes;
    }

    public static void setLinks(List<Link> linksList) {
        links = new ConcurrentLinkedQueue<>();
        LoadThread.links.addAll(linksList);
    }
}