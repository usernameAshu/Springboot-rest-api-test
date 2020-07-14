package com.mohanty.springbootapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDtoRepository {

    private int total_count ;
    private boolean incomplete_results;

    @JsonProperty(value = "items")
    private List<HottestRepository> itemsHottestRepositories ;

}
