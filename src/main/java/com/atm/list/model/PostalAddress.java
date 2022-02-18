
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
    "AddressLine",
    "StreetName",
    "TownName",
    "CountrySubDivision",
    "Country",
    "PostCode"
})
@Generated("jsonschema2pojo")
public class PostalAddress {

    @JsonProperty("AddressLine")
    public List<String> addressLine = null;
    @JsonProperty("StreetName")
    public String streetName;
    @JsonProperty("TownName")
    public String townName;
    @JsonProperty("CountrySubDivision")
    public List<String> countrySubDivision = null;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("PostCode")
    public String postCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
