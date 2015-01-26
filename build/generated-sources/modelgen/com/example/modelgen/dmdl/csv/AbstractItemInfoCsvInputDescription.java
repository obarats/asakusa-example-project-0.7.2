package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.ItemInfo;
/**
 * An abstract implementation of {@link ItemInfo} importer description using Direct I/O CSV.
 */
public abstract class AbstractItemInfoCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends ItemInfo> getModelType() {
        return ItemInfo.class;
    }
    @Override public Class<ItemInfoCsvFormat> getFormat() {
        return ItemInfoCsvFormat.class;
    }
}