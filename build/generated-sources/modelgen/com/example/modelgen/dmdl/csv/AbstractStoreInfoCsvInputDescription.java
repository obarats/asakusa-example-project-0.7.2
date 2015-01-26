package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.StoreInfo;
/**
 * An abstract implementation of {@link StoreInfo} importer description using Direct I/O CSV.
 */
public abstract class AbstractStoreInfoCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends StoreInfo> getModelType() {
        return StoreInfo.class;
    }
    @Override public Class<StoreInfoCsvFormat> getFormat() {
        return StoreInfoCsvFormat.class;
    }
}