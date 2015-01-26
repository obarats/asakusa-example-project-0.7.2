package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import java.io.IOException;
/**
 * <code>joined_sales_info</code>をTSVなどのレコード形式で出力する。
 */
public final class JoinedSalesInfoOutput implements ModelOutput<JoinedSalesInfo> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public JoinedSalesInfoOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(JoinedSalesInfo model) throws IOException {
        emitter.emit(model.getItemCodeOption());
        emitter.emit(model.getAmountOption());
        emitter.emit(model.getSellingPriceOption());
        emitter.emit(model.getCategoryCodeOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}