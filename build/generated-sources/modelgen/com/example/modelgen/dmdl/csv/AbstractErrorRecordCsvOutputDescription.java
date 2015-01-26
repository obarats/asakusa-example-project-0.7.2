package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 * An abstract implementation of {@link ErrorRecord} exporter description using Direct I/O CSV.
 */
public abstract class AbstractErrorRecordCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends ErrorRecord> getModelType() {
        return ErrorRecord.class;
    }
    @Override public Class<ErrorRecordCsvFormat> getFormat() {
        return ErrorRecordCsvFormat.class;
    }
}