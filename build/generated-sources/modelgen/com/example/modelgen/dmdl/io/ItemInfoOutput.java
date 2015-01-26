package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.ItemInfo;
import java.io.IOException;
/**
 * <code>item_info</code>をTSVなどのレコード形式で出力する。
 */
public final class ItemInfoOutput implements ModelOutput<ItemInfo> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public ItemInfoOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(ItemInfo model) throws IOException {
        emitter.emit(model.getItemCodeOption());
        emitter.emit(model.getItemNameOption());
        emitter.emit(model.getDepartmentCodeOption());
        emitter.emit(model.getDepartmentNameOption());
        emitter.emit(model.getCategoryCodeOption());
        emitter.emit(model.getCategoryNameOption());
        emitter.emit(model.getUnitSellingPriceOption());
        emitter.emit(model.getRegisteredDateOption());
        emitter.emit(model.getBeginDateOption());
        emitter.emit(model.getEndDateOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}