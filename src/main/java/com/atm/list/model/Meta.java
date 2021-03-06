
package com.atm.list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@JsonSerialize
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)@JsonPropertyOrder({
    "LastUpdated",
    "TotalResults",
    "Agreement",
    "License",
    "TermsOfUse"
})
@Generated("jsonschema2pojo")
public class Meta {

    @JsonProperty("LastUpdated")
    public String lastUpdated;
    @JsonProperty("TotalResults")
    public Integer totalResults;
    @JsonProperty("Agreement")
    public String agreement;
    @JsonProperty("License")
    public String license;
    @JsonProperty("TermsOfUse")
    public String termsOfUse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
