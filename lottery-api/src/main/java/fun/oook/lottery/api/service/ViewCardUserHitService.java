package fun.oook.lottery.api.service;

import fun.oook.lottery.commons.db.entity.ViewCardUserHit;
import fun.oook.lottery.commons.util.PageBean;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public interface ViewCardUserHitService {

    PageBean<ViewCardUserHit> listByGameId(int gameId, int currentPage, int limit);
}
