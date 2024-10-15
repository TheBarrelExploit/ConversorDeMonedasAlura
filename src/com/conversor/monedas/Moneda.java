package com.conversor.monedas;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    private Double conversion;
    private String targetCode;
    private Double conversionRate;
    private String baseCode;
    private String result;

    public Moneda(ConversorMoneda conversor) {
        this.targetCode = conversor.targetCode();
        this.baseCode = conversor.baseCode();
        this.conversion = conversor.conversionResult();
        this.conversionRate = conversor.conversionRate();
        this.result = conversor.result();
    }

    public Double getConversion() {
        return conversion;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public String getResult() {
        return result;
    }


}

