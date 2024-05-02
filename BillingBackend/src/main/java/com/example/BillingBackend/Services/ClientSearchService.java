package com.example.BillingBackend.Services;

import com.example.BillingBackend.Cofigurations.WebClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientSearchService {
 @Autowired
 private WebClientConfig webClientConfig;

    public Mono<List> searchClients(String clientCode, Long loanAccNo) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParamIfPresent("clientCode", Optional.ofNullable(clientCode))
                        .queryParamIfPresent("loanAccNo", Optional.ofNullable(loanAccNo))
                        .build())
                .retrieve()
                .bodyToMono(List.class);
    }
}
