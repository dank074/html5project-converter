package com.joopie.ffconverter;

import java.io.File;
import com.joopie.ffconverter.converters.IConverter;
import com.joopie.ffconverter.converters.furniture.FurnitureConverter;
import com.joopie.ffconverter.converters.util.spritesheet.SpritesheetConverter;
import com.joopie.ffconverter.downloader.Downloader;
import com.joopie.ffconverter.downloader.furniture.FurnitureDownloader;
import org.lwjgl.Sys;

/**
 * Created by jospi on 10-4-2017.
 */
public class FFConverter {
    public static void main(String[] args) throws Exception {
        File outputFolder = new File("D:/ffconverter/");
        if (!outputFolder.isDirectory()) {
            outputFolder.mkdirs();
        }

        IConverter furnitureConverter = new FurnitureConverter();
        IConverter spritesheetConverter = new SpritesheetConverter();

        Downloader downloader = new Downloader();
        downloader.addDownloader(new FurnitureDownloader(habboAssetSWF -> {
            System.out.println("Attempt parsing furniture: " + habboAssetSWF.getDocumentClass());

            try {
                File assetOuputFolder = new File(outputFolder + "/" + habboAssetSWF.getDocumentClass());
                if (!assetOuputFolder.isDirectory()) {
                    assetOuputFolder.mkdirs();
                }
                else if(assetOuputFolder.list().length > 0){
                    System.out.println("Furniture already exists or the directory is not empty!");

                    return;
                }

                furnitureConverter.fromHabboAsset(habboAssetSWF, assetOuputFolder);
                spritesheetConverter.fromHabboAsset(habboAssetSWF, assetOuputFolder);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }));
        downloader.download();
        downloader = null;
    }
}