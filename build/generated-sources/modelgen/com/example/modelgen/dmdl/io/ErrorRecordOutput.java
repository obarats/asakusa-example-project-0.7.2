package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.ErrorRecord;
import java.io.IOException;
/**
 * <code>error_record</code>をTSVなどのレコード形式で出力する。
 */
public final class ErrorRecordOutput implements ModelOutput<ErrorRecord> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public ErrorRecordOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(ErrorRecord model) throws IOException {
        emitter.emit(model.getFileNameOption());
        emitter.emit(model.getSalesDateTimeOption());
        emitter.emit(model.getStoreCodeOption());
        emitter.emit(model.getItemCodeOption());
        emitter.emit(model.getMessageOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}