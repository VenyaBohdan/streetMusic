package com.street.interlayer.service.impl;

import com.street.interlayer.model.Account;
import com.street.interlayer.model.Card;
import com.street.interlayer.service.AccountService;
import com.street.interlayer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CardServiceImpl implements CardService {

    @Autowired
    private AccountService accountService;

    @Value("${payment.server.url}")
    private String paymentServerUrl;
    private final String CARD = "card/";

    @Override
    public List<Card> getAllCards() {
        RestTemplate restTemplate = new RestTemplate();
        Card[] cardResponse = restTemplate.getForObject(paymentServerUrl + CARD, Card[].class);
        List<Card> cards = cardResponse == null ? Collections.emptyList() : Arrays.asList(cardResponse);
        cards.forEach(card -> {
            Account account = accountService.getAccountById(card.getOwnerId());
            card.setAccount(account);
        });
        return cards;
     }

     @Override
     public Card getCardById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(paymentServerUrl + CARD + id, Card.class);
        Account account = accountService.getAccountById(card.getOwnerId());
        card.setAccount(account);
        return card;
     }

    @Override
    public Card saveCard(Card card) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(paymentServerUrl + CARD, card, Card.class).getBody();
    }

    @Override
    public void deleteCard(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(paymentServerUrl + CARD + id);
    }
}
