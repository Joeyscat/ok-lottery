package fun.oook.lottery.api.service.impl;

import com.github.pagehelper.PageHelper;
import fun.oook.lottery.api.service.UserService;
import fun.oook.lottery.commons.config.RedisKeys;
import fun.oook.lottery.commons.db.entity.*;
import fun.oook.lottery.commons.db.mapper.CardUserGameMapper;
import fun.oook.lottery.commons.db.mapper.CardUserMapper;
import fun.oook.lottery.commons.db.mapper.ViewCardUserHitMapper;
import fun.oook.lottery.commons.util.ApiResult;
import fun.oook.lottery.commons.util.PageBean;
import fun.oook.lottery.commons.util.PasswordUtil;
import fun.oook.lottery.commons.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {

    private static final int MAX_LOGIN_ERROR_TIMES = 5;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private CardUserGameMapper userGameMapper;

    @Resource
    private CardUserMapper userMapper;

    @Resource
    private ViewCardUserHitMapper userHitMapper;

    @Override
    public CardUserDTO info(final String sessionId) {
        final CardUser user = (CardUser) redisUtil.get(RedisKeys.USER_SESSION_ID + sessionId);
        if (user == null) {
            return null;
        }
        final CardUserDTO userDTO = new CardUserDTO(user);
        userDTO.setGames(userGameMapper.getGamesNumByUserId(user.getId()));
        userDTO.setProducts(userGameMapper.getPrizesNumByUserId(user.getId()));

        return userDTO;
    }

    @Override
    public PageBean<ViewCardUserHit> hit(final int gameId, final int curPage, final int limit, final Integer userId) {
        final ViewCardUserHitExample example = new ViewCardUserHitExample();
        final ViewCardUserHitExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        if (gameId != -1) {
            criteria.andGameidEqualTo(gameId);
        }

        final long total = userHitMapper.countByExample(example);
        PageHelper.startPage(curPage, limit);
        final List<ViewCardUserHit> all = userHitMapper.selectByExample(example);

        return new PageBean<>(curPage, limit, total, all);
    }

    @Override
    public ApiResult<CardUser> login(final String account, final String password, final HttpSession session) {

        Integer errorTimes = (Integer) redisUtil.get(RedisKeys.USER_LOGIN_TIMES + account);
        if (errorTimes != null && errorTimes >= MAX_LOGIN_ERROR_TIMES) {
            return new ApiResult<>(0, "密码错误" + MAX_LOGIN_ERROR_TIMES + "次，请5分钟后再登录", null);
        }
        CardUserExample userExample = new CardUserExample();
        userExample.createCriteria().andUnameEqualTo(account).andPasswdEqualTo(PasswordUtil.encodePassword(password));
        List<CardUser> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            CardUser user = users.get(0);
            //信息脱敏，不要将敏感信息带入session以免其他接口不小心泄露到前台
            user.setPasswd(null);
            user.setIdcard(null);
            session.setAttribute("loginUserId", user.getId());
            redisUtil.set("loginUser:" + user.getId(), session.getId());
            redisUtil.set(RedisKeys.USER_SESSION_ID + session.getId(), user);
            return new ApiResult<>(1, "登录成功", user);
        }
        //错误计数，5次锁定5分钟
        redisUtil.incr(RedisKeys.USER_LOGIN_TIMES + account, 1);
        redisUtil.expire(RedisKeys.USER_LOGIN_TIMES + account, 60 * 5);
        return new ApiResult<>(0, "账户名或密码错误", null);
    }

    @Override
    public void logout(final String userId) {
        redisUtil.del("loginUser:" + userId);
    }
}
