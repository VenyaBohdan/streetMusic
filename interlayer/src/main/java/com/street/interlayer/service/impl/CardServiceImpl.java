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
    private String paymentServiceUrl;
    final private String CARD = "card/";

    @Override
    public List<Card> getAllCards() {
        RestTemplate restTemplate = new RestTemplate();
        Card[] cardResponse = restTemplate.getForObject(paymentServiceUrl + CARD, Card[].class);
        List<Card> cards = cardResponse == null ? Collections.emptyList() : Arrays.asList(cardResponse);
        cards.forEach(card -> {
            Account account = accountService.getAccountById(card.getOwnerId());
            card.setAccount(account);
        });
        return cards;
     }

     @Override
     public Card getCardById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(paymentServiceUrl + CARD + id, Card.class);
     }

    @Override
    public Card saveCard(Card card) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(paymentServiceUrl + CARD, card, Card.class).getBody();
    }

    @Override
    public void deleteCard(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(paymentServiceUrl + CARD + id);
    }
}
