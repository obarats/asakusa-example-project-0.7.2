package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.ItemInfo;
/**
 * An abstract implementation of {@link ItemInfo} exporter description using Direct I/O CSV.
 */
public abstract class AbstractItemInfoCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends ItemInfo> getModelType() {
        return ItemInfo.class;
    }
    @Override public Class<ItemInfoCsvFormat> getFormat() {
        return ItemInfoCsvFormat.class;
    }
}