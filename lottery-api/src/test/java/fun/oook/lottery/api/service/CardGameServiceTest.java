package fun.oook.lottery.api.service;

import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.util.PageBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class CardGameServiceTest {

    @Resource
    private CardGameService cardGameService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void insertOne(){
        final CardGame cardGame = new CardGame();
        cardGame.setTitle("ss");
        cardGame.setType(0);
        cardGame.setStatus(0);
        cardGame.setInfo("ss");
        cardGame.setPic("ss");
        cardGame.setStarttime(new Date());
        cardGame.setEndtime(Date.from(new Date().toInstant().plusSeconds(600)));

        final int insert = cardGameService.insertOne(cardGame);
        Assertions.assertEquals(1, insert);
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