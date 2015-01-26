package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * An abstract implementation of {@link CategorySummary} importer description using Direct I/O CSV.
 */
public abstract class AbstractCategorySummaryCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends CategorySummary> getModelType() {
        return CategorySummary.class;
    }
    @Override public Class<CategorySummaryCsvFormat> getFormat() {
        return CategorySummaryCsvFormat.class;
    }
}