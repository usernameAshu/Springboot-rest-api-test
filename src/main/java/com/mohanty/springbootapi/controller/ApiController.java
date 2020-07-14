package com.mohanty.springbootapi.controller;

import com.mohanty.springbootapi.Models.HottestRepository;
import com.mohanty.springbootapi.Models.OldestUserAccounts;
import com.mohanty.springbootapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping
    public ResponseEntity<String> helloPage() {

        return new ResponseEntity<>("Welcome Page :api/v1", HttpStatus.OK);
    }

    @GetMapping("/getHottestRepository")
    public ResponseEntity<Stream<HottestRepository>> getHottestRepository() {

        return new ResponseEntity<>(
                apiService.getHottestRepositories().getItemsHottestRepositories().stream().limit(3),
                HttpStatus.OK);

    }

    @GetMapping("/getOldestUserAccounts")
    public ResponseEntity<Stream<OldestUserAccounts>> getOldestUserAccounts() {

        return new ResponseEntity<>(
                apiService.getOldestUserAccounts().getItemsOldestUserAccounts().stream().limit(3),
                HttpStatus.OK
        );
    }

}
