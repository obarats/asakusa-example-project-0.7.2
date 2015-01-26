package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.StoreInfo;
import java.io.IOException;
/**
 * <code>store_info</code>をTSVなどのレコード形式で出力する。
 */
public final class StoreInfoOutput implements ModelOutput<StoreInfo> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public StoreInfoOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(StoreInfo model) throws IOException {
        emitter.emit(model.getStoreCodeOption());
        emitter.emit(model.getStoreNameOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}