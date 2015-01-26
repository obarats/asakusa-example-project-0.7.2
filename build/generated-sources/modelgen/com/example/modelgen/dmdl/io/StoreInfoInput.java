package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import com.example.modelgen.dmdl.model.StoreInfo;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>store_info</code>を読み出す
 */
public final class StoreInfoInput implements ModelInput<StoreInfo> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public StoreInfoInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(StoreInfo model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getStoreCodeOption());
        parser.fill(model.getStoreNameOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}