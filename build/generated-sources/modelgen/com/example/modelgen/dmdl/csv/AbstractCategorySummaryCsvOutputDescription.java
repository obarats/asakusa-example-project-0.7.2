package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * An abstract implementation of {@link CategorySummary} exporter description using Direct I/O CSV.
 */
public abstract class AbstractCategorySummaryCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends CategorySummary> getModelType() {
        return CategorySummary.class;
    }
    @Override public Class<CategorySummaryCsvFormat> getFormat() {
        return CategorySummaryCsvFormat.class;
    }
}