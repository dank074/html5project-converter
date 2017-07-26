package com.joopie.ffconverter.downloader;

import com.joopie.ffconverter.HabboAssetSWF;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Created by jospi on 23-4-2017.
 */
public class Downloader {
    private List<IDownloader> downloaders = new ArrayList<>();

    public void addDownloader(IDownloader downloader) {
        this.downloaders.add(downloader);
    }

    public void download() {
        try {
            ExecutorService downloadPool = Executors.newFixedThreadPool(1);
            List<Callable<Object>> downloadTasks = new ArrayList<>();

            for (IDownloader downloader : this.downloaders) {
                try {
                    downloader.prepareDownloader(downloadTasks);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            downloadPool.invokeAll(downloadTasks);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
