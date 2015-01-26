package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.StoreInfo;
/**
 * An abstract implementation of {@link StoreInfo} exporter description using Direct I/O CSV.
 */
public abstract class AbstractStoreInfoCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends StoreInfo> getModelType() {
        return StoreInfo.class;
    }
    @Override public Class<StoreInfoCsvFormat> getFormat() {
        return StoreInfoCsvFormat.class;
    }
}