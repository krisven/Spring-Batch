package com.krisven;

import org.springframework.batch.item.ItemProcessor;

public class CreditBillProcessor implements ItemProcessor<CreditBill, CreditBill> {

    public CreditBill process(CreditBill creditBill) throws Exception {
        creditBill.setName("Jerry");
        System.out.println(creditBill.toString());
        return creditBill;
    }
}
