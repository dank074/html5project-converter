package com.joopie.ffconverter;

import com.jpexs.decompiler.flash.SWF;
import com.jpexs.decompiler.flash.tags.DefineBinaryDataTag;
import com.jpexs.decompiler.flash.tags.Tag;
import com.jpexs.decompiler.flash.tags.base.ImageTag;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jospi on 23-4-2017.
 */
public class HabboAssetSWF {
    private InputStream inputStream;
    private SWF swf;

    public HabboAssetSWF(InputStream inputStream) throws InterruptedException, IOException {
        this.inputStream = inputStream;
        this.swf = new SWF(this.inputStream, false, false);
    }

    public void dispose() {
        this.swf.clearAllCache();
        this.swf = null;

        //this.inputStream.close();
    }

    public HabboAssetSWF(File swfFile) throws InterruptedException, IOException {
        this(new FileInputStream(swfFile));
    }

    private Stream<Tag> streamTags() {
        return this.swf.getTags()
                .toArrayList()
                .stream();
    }

    private Stream<Tag> streamTagsById(int tagId) {
        return this.streamTags()
                .filter((tag) -> tag.getId() == tagId);
    }

    private Stream<ImageTag> streamImageTags() {
        return this.streamTagsById(36)
                .map(tag -> (ImageTag) tag);
    }

    public List<ImageTag> getImageTags() {
        return this.streamImageTags()
                .collect(Collectors.toList());
    }

    public ImageTag getImageTagByName(String name) {
        Optional<ImageTag> streamTag = this.streamImageTags()
                .filter(tag -> tag.getClassName().equals(name))
                .findFirst();

        if (streamTag.isPresent()) {
            return streamTag.get();
        }

        return null;
    }

    private Stream<DefineBinaryDataTag> streamBinaryTags() {
        return this.streamTagsById(87)
                .map(tag -> (DefineBinaryDataTag) tag);
    }

    public List<DefineBinaryDataTag> getBinaryTags() {
        return this.streamBinaryTags()
                .collect(Collectors.toList());
    }

    public DefineBinaryDataTag getBinaryTagByName(String name) {
        Optional<DefineBinaryDataTag> streamTag = this.streamBinaryTags()
                .filter(tag -> tag.getClassName().equals(name))
                .findFirst();

        if (streamTag.isPresent()) {
            return streamTag.get();
        }

        return null;
    }

    public String getDocumentClass() {
        return this.swf.getDocumentClass();
    }

    public String getFullClassName(String type, boolean documentNameTwice) {
        String result = this.swf.getDocumentClass() + "_";
        if (documentNameTwice) {
            result += this.swf.getDocumentClass() + "_";
        }

        return result + type;
    }
}
