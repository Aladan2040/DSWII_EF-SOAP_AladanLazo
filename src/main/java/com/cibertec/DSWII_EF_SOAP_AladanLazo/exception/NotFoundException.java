package com.cibertec.DSWII_EF_SOAP_AladanLazo.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{http://www.cibertec.com/ws}001")
public class NotFoundException  extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
