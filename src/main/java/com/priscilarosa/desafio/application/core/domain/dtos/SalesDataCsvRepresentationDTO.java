package com.priscilarosa.desafio.application.core.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesDataCsvRepresentationDTO {
    @CsvBindByName(column = "purchaser name")
    private String purchaserName;
    @CsvBindByName(column = "item description")
    private String itemDescription;
    @CsvBindByName(column = "item price")
    private Double itemPrice;
    @CsvBindByName(column = "purchase count")
    private Integer purchaseCount;
    @CsvBindByName(column = "merchant address")
    private String merchantAddress;
    @CsvBindByName(column = "merchant name")
    private String merchantName;
}
