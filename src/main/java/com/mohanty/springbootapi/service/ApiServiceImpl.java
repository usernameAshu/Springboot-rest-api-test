package com.mohanty.springbootapi.service;

import com.mohanty.springbootapi.Models.HottestRepository;
import com.mohanty.springbootapi.Models.ResponseDtoRepository;
import com.mohanty.springbootapi.Models.ResponseDtoUserAccounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseDtoRepository getHottestRepositories() {

        String url = "https://api.github.com/search/repositories";
        String backupUrl = "https://api.github.com/search/repositories?q=2020-07-05&sort=stars&order=desc";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "application/vnd.github.preview");

        HttpEntity<HottestRepository> httpEntity = new HttpEntity<>(httpHeaders);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("q", "2020-07-05")
                .queryParam("sort", "stars")
                .queryParam("order", "desc");

        ResponseEntity<ResponseDtoRepository> response =
                restTemplate.exchange(
                        builder.build().toUri(),
                        HttpMethod.GET,
                        httpEntity,
                        ResponseDtoRepository.class
                );

        return response.getBody();
    }

    @Override
    public ResponseDtoUserAccounts getOldestUserAccounts() {

        String url ="https://api.github.com/search/users";
        String backupUrl = "https://api.github.com/search/repositories?q=followers:0&sort=joined&order=asc";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/vnd.github.preview");

        HttpEntity entity = new HttpEntity(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("q","followers:0")
                .queryParam("sort","joined")
                .queryParam("order","asc") ;

        ResponseEntity<ResponseDtoUserAccounts> response =
        restTemplate.exchange(builder.build().toUri(),HttpMethod.GET,entity, ResponseDtoUserAccounts.class);

        return response.getBody();
    }
}
