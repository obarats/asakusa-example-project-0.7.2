package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import com.example.modelgen.dmdl.model.ItemInfo;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>item_info</code>を読み出す
 */
public final class ItemInfoInput implements ModelInput<ItemInfo> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public ItemInfoInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(ItemInfo model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getItemCodeOption());
        parser.fill(model.getItemNameOption());
        parser.fill(model.getDepartmentCodeOption());
        parser.fill(model.getDepartmentNameOption());
        parser.fill(model.getCategoryCodeOption());
        parser.fill(model.getCategoryNameOption());
        parser.fill(model.getUnitSellingPriceOption());
        parser.fill(model.getRegisteredDateOption());
        parser.fill(model.getBeginDateOption());
        parser.fill(model.getEndDateOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}