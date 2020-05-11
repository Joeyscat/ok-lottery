package fun.oook.lottery.api.service;

import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.util.PageBean;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public interface CardGameService {

    PageBean<CardGame> listByStatus(int status, int currentPage, int limit);

    CardGame selectByGameId(int gameId);
}
