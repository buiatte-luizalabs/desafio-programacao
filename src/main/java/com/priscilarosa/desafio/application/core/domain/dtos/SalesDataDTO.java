package com.priscilarosa.desafio.application.core.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class SalesDataDTO {
    @JsonProperty("purchaserName")
    private String purchaserName;
    @JsonProperty("itemDescription")
    private String itemDescription;
    @JsonProperty("itemPrice")
    private Double itemPrice;
    @JsonProperty("purchaseCount")
    private Integer purchaseCount;
    @JsonProperty("merchantAddress")
    private String merchantAddress;
    @JsonProperty("merchantName")
    private String merchantName;

}
