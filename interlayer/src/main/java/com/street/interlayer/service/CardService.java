package com.street.interlayer.service;

import com.street.interlayer.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    List<Card> getAllCards();
    Card getCardById(String id);
    Card saveCard(Card card);
    void deleteCard(String id);

}
