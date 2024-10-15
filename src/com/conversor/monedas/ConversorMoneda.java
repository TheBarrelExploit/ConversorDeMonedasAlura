package com.conversor.monedas;

public record ConversorMoneda(Double conversionResult, Double conversionRate, String targetCode, String baseCode, String result) {
}
