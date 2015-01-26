package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import com.example.modelgen.dmdl.model.CategorySummary;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>category_summary</code>を読み出す
 */
public final class CategorySummaryInput implements ModelInput<CategorySummary> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public CategorySummaryInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(CategorySummary model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getCategoryCodeOption());
        parser.fill(model.getAmountTotalOption());
        parser.fill(model.getSellingPriceTotalOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}