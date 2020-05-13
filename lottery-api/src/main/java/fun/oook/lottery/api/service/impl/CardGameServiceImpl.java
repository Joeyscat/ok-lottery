package fun.oook.lottery.api.service.impl;

import com.github.pagehelper.PageHelper;
import fun.oook.lottery.api.service.CardGameService;
import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.db.entity.CardGameExample;
import fun.oook.lottery.commons.db.mapper.CardGameMapper;
import fun.oook.lottery.commons.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Service
public class CardGameServiceImpl implements CardGameService {

    @Resource
    private CardGameMapper gameMapper;

    @Override
    public PageBean<CardGame> listByStatus(final int status, final int currentPage, final int limit) {
        final Date now = new Date();
        final CardGameExample example = new CardGameExample();
        final CardGameExample.Criteria criteria = example.createCriteria();

        switch (status) {
            case 0:
                criteria.andStarttimeGreaterThan(now);
                break;
            case 1:
                criteria.andStarttimeLessThanOrEqualTo(now).andEndtimeGreaterThan(now);
                break;
            case 2:
                criteria.andEndtimeLessThanOrEqualTo(now);
                break;
            default:
                break;
        }
        final long total = gameMapper.countByExample(example);
        example.setOrderByClause("starttime desc");
        PageHelper.startPage(currentPage, limit);

        return new PageBean<>(currentPage, limit, total, gameMapper.selectByExample(example));
    }

    @Override
    public CardGame selectByGameId(final int gameId) {
        return gameMapper.selectByPrimaryKey(gameId);
    }

    @Override
    public int insertOne(final CardGame cardGame) {
        final int selective = gameMapper.insert(cardGame);
        return selective;
    }
}
