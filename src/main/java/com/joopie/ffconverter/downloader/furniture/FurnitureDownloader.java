package com.joopie.ffconverter.downloader.furniture;

import com.joopie.ffconverter.HabboAssetSWF;
import com.joopie.ffconverter.downloader.IDownloader;
import com.joopie.ffconverter.downloader.furniture.resources.Furnidata;
import com.joopie.ffconverter.downloader.furniture.resources.FurnidataParser;

import java.lang.reflect.Executable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Created by jospi on 23-4-2017.
 */
public class FurnitureDownloader implements IDownloader {
    public static class FurnitureRunnableDownloader implements Runnable{
        private static final String DYNAMIC_DOWNLOAD_URL = "https://images.habbo.com/dcr/hof_furni/";

        private int revision;
        private String className;
        private Consumer<HabboAssetSWF> callback;

        public FurnitureRunnableDownloader(Consumer<HabboAssetSWF> callback, int revision, String className) {
            this.callback = callback;
            this.revision = revision;
            this.className = className;
        }

        @Override
        public void run() {
            try {
                URL swfURL = new URL(DYNAMIC_DOWNLOAD_URL + this.revision + "/" + this.className + ".swf");
                HabboAssetSWF habboAssetSWF = new HabboAssetSWF(swfURL.openStream());
                this.callback.accept(habboAssetSWF);
                //habboAssetSWF.dispose();
                habboAssetSWF = null;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Consumer<HabboAssetSWF> callback;

    public FurnitureDownloader(Consumer<HabboAssetSWF> callback) {
        this.callback = callback;
    }

    //https://images.habbo.com/dcr/hof_furni/45508/ads_calip_cola.swf

    /*@Override
    public void prepareDownloader(List<Callable<Object>> downloadTasks) throws Exception {
        downloadTasks.add(Executors.callable(new FurnitureRunnableDownloader(this.callback, 45508, "ads_calip_cola")));
    }*/

    @Override
    public void prepareDownloader(List<Callable<Object>> downloadTasks) throws Exception {
        Furnidata furnidata = FurnidataParser.getFurnidata();
        if (furnidata != null) {
            List<String> itemClassNames = new ArrayList<>();

            for (Furnidata.Roomitemtypes.Furnitype item : furnidata.getRoomitemtypes().getFurnitype()) {
                String className = item.getClassname().split("\\*")[0];
                if (!itemClassNames.contains(className)) {
                    downloadTasks.add(Executors.callable(new FurnitureRunnableDownloader(this.callback, item.getRevision(), className)));
                }

                itemClassNames.add(className);
            }

            for (Furnidata.Wallitemtypes.Furnitype item : furnidata.getWallitemtypes().getFurnitype()) {
                String className = item.getClassname().split("\\*")[0];
                if (!itemClassNames.contains(className)) {
                    downloadTasks.add(Executors.callable(new FurnitureRunnableDownloader(this.callback, item.getRevision(), className)));
                }

                itemClassNames.add(className);
            }
        }
    }
}
