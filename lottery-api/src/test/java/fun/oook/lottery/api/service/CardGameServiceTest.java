package fun.oook.lottery.api.service;

import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.util.PageBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CardGameServiceTest {

    @Resource
    private CardGameService cardGameService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listByStatus() {
        final PageBean<CardGame> list = cardGameService.listByStatus(-1, 1, 10);

        Assertions.assertNotEquals(0, list.getItems());

        list.getItems().forEach(i -> {
            System.out.println(i.getTitle());
        });
    }

    @Test
    void selectByGameId() {
        final CardGame cardGame = cardGameService.selectByGameId(1);

        Assertions.assertNotNull(cardGame);

        System.out.println(cardGame.getTitle());
    }
}