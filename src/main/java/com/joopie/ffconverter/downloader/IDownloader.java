package com.joopie.ffconverter.downloader;

import com.joopie.ffconverter.HabboAssetSWF;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Created by jospi on 23-4-2017.
 */
public interface IDownloader {
    void prepareDownloader(List<Callable<Object>> downloadTasks) throws Exception;
}
