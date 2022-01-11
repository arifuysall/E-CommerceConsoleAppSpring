package com.kodluyoruz.ecommerceconsoleapp.Models.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "creditcart")
public class CreditCartProperties {
    private int creditCartCommission;
}
