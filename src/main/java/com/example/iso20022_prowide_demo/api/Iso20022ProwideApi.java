package com.example.iso20022_prowide_demo.api;

import com.prowidesoftware.swift.model.mx.MxPacs00800111;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pro")
public class Iso20022ProwideApi {

    @PostMapping(value = "test", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String test(@RequestBody String xml) {
        System.out.println(xml);
        var mx = MxPacs00800111.parse(xml);
        System.out.println(mx.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
        return "Success";
    }

    /*Sample Payload
    <Envelope xmlns="urn:iso:std:iso:20022:tech:xsd:head.001.001.01">
    <AppHdr>
        <Fr>
            <FIId>
                <FinInstnId>
                    <BICFI>AAAAUS33XXX</BICFI>
                </FinInstnId>
            </FIId>
        </Fr>
        <To>
            <FIId>
                <FinInstnId>
                    <BICFI>BBBBGB22XXX</BICFI>
                </FinInstnId>
            </FIId>
        </To>
        <BizMsgIdr>20240912ABCD123456</BizMsgIdr>
        <MsgDefIdr>pacs.008.001.11</MsgDefIdr>
        <CreDt>2024-09-12T20:00:00</CreDt>
    </AppHdr>
    <Document xmlns="urn:iso:std:iso:20022:tech:xsd:pacs.008.001.11">
        <FIToFICstmrCdtTrf>
            <GrpHdr>
                <MsgId>123456789</MsgId>
                <CreDtTm>2024-09-12T20:00:00</CreDtTm>
                <NbOfTxs>1</NbOfTxs>
                <SttlmInf>
                    <SttlmMtd>CLRG</SttlmMtd>
                </SttlmInf>
                <InstgAgt>
                    <FinInstnId>
                        <BICFI>AAAAUS33XXX</BICFI>
                    </FinInstnId>
                </InstgAgt>
                <InstdAgt>
                    <FinInstnId>
                        <BICFI>BBBBGB22XXX</BICFI>
                    </FinInstnId>
                </InstdAgt>
            </GrpHdr>
            <CdtTrfTxInf>
                <PmtId>
                    <InstrId>INSTRUCTION123</InstrId>
                    <EndToEndId>ETOE123456</EndToEndId>
                    <TxId>TX123456789</TxId>
                </PmtId>
                <IntrBkSttlmAmt Ccy="USD">1000.00</IntrBkSttlmAmt>
                <ChrgBr>SLEV</ChrgBr>
                <Dbtr>
                    <Nm>Debtor Name</Nm>
                    <PstlAdr>
                        <Ctry>US</Ctry>
                        <AdrLine>123 Debtor Street</AdrLine>
                    </PstlAdr>
                </Dbtr>
                <DbtrAcct>
                    <Id>
                        <IBAN>US12345678901234567890</IBAN>
                    </Id>
                </DbtrAcct>
                <Cdtr>
                    <Nm>Creditor Name</Nm>
                    <PstlAdr>
                        <Ctry>GB</Ctry>
                        <AdrLine>456 Creditor Avenue</AdrLine>
                    </PstlAdr>
                </Cdtr>
                <CdtrAcct>
                    <Id>
                        <IBAN>GB09876543210987654321</IBAN>
                    </Id>
                </CdtrAcct>
            </CdtTrfTxInf>
        </FIToFICstmrCdtTrf>
    </Document>
</Envelope>


    * */
}
