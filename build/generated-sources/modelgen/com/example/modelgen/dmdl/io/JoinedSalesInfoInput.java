package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>joined_sales_info</code>を読み出す
 */
public final class JoinedSalesInfoInput implements ModelInput<JoinedSalesInfo> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public JoinedSalesInfoInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(JoinedSalesInfo model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getItemCodeOption());
        parser.fill(model.getAmountOption());
        parser.fill(model.getSellingPriceOption());
        parser.fill(model.getCategoryCodeOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}