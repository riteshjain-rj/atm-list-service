
package com.atm.list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonSerialize
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)@JsonPropertyOrder({
    "Identification",
    "SupportedCurrencies",
    "Location"
})
@Generated("jsonschema2pojo")
public class Atm {

    @JsonProperty("Identification")
    public String identification;
    @JsonProperty("SupportedCurrencies")
    public List<String> supportedCurrencies = null;
    @JsonProperty("Location")
    public Location location;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
