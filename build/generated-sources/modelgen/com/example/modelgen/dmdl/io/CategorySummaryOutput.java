package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.CategorySummary;
import java.io.IOException;
/**
 * <code>category_summary</code>をTSVなどのレコード形式で出力する。
 */
public final class CategorySummaryOutput implements ModelOutput<CategorySummary> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public CategorySummaryOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(CategorySummary model) throws IOException {
        emitter.emit(model.getCategoryCodeOption());
        emitter.emit(model.getAmountTotalOption());
        emitter.emit(model.getSellingPriceTotalOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}