package com.mohanty.springbootapi.service;

import com.mohanty.springbootapi.Models.ResponseDtoRepository;
import com.mohanty.springbootapi.Models.ResponseDtoUserAccounts;

public interface ApiService {

    public ResponseDtoRepository getHottestRepositories();

    public ResponseDtoUserAccounts getOldestUserAccounts();
}
