package fun.oook.lottery.api.service;

import fun.oook.lottery.commons.db.entity.CardUser;
import fun.oook.lottery.commons.db.entity.CardUserDTO;
import fun.oook.lottery.commons.db.entity.ViewCardUserHit;
import fun.oook.lottery.commons.util.ApiResult;
import fun.oook.lottery.commons.util.PageBean;

import javax.servlet.http.HttpSession;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public interface UserService {

    CardUserDTO info(String sessionId);

    PageBean<ViewCardUserHit> hit(int gameId, int curPage, int limit, Integer userId);

    ApiResult<CardUser> login(String account, String password, HttpSession session);

    void logout(String userId);
}
