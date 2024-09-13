package com.example.iso20022_prowide_demo;


import com.prowidesoftware.swift.model.mx.MxPacs00800111;
import com.prowidesoftware.swift.model.mx.dic.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


public class Iso20022ProwideMain {

    public static void main(String[] args) throws Exception {
        MxPacs00800111 mxPacs00800111 = new MxPacs00800111();
        var header = new com.prowidesoftware.swift.model.mx.BusinessAppHdrV03();
        mxPacs00800111.setAppHdr(header);
        FIToFICustomerCreditTransferV11 fIToFICustomerCreditTransfer = new FIToFICustomerCreditTransferV11();

        GroupHeader96 groupHeader = new GroupHeader96();
        groupHeader.setMsgId("MSG123456");
        groupHeader.setCreDtTm(OffsetDateTime.now());
        groupHeader.setNbOfTxs("1");
        fIToFICustomerCreditTransfer.setGrpHdr(groupHeader);

        CreditTransferTransaction58 creditTransferTransaction = new CreditTransferTransaction58();
        PaymentIdentification13 paymentId = new PaymentIdentification13();
        paymentId.setInstrId("Instr123");
        paymentId.setEndToEndId("E2E123456");
        creditTransferTransaction.setPmtId(paymentId);

        ActiveOrHistoricCurrencyAndAmount instructedAmount = new ActiveOrHistoricCurrencyAndAmount();
        instructedAmount.setCcy("USD");
        instructedAmount.setValue(new BigDecimal("1000.00"));
        creditTransferTransaction.setInstdAmt(instructedAmount);

        fIToFICustomerCreditTransfer.getCdtTrfTxInf().add(creditTransferTransaction);

        SupplementaryData1 supplementaryData = new SupplementaryData1();
        supplementaryData.setPlcAndNm("ExampleData");
        fIToFICustomerCreditTransfer.getSplmtryData().add(supplementaryData);

        mxPacs00800111.setFIToFICstmrCdtTrf(fIToFICustomerCreditTransfer);

        String xml = mxPacs00800111.message();
        System.out.println(xml);
    }
}
