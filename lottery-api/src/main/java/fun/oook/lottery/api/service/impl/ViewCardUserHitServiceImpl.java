package fun.oook.lottery.api.service.impl;

import com.github.pagehelper.PageHelper;
import fun.oook.lottery.api.service.ViewCardUserHitService;
import fun.oook.lottery.commons.db.entity.ViewCardUserHit;
import fun.oook.lottery.commons.db.entity.ViewCardUserHitExample;
import fun.oook.lottery.commons.db.mapper.ViewCardUserHitMapper;
import fun.oook.lottery.commons.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Service
public class ViewCardUserHitServiceImpl implements ViewCardUserHitService {

    @Resource
    private ViewCardUserHitMapper hitMapper;

    @Override
    public PageBean<ViewCardUserHit> listByGameId(final int gameId, final int currentPage, final int limit) {
        ViewCardUserHitExample example = new ViewCardUserHitExample();
        example.createCriteria().andGameidEqualTo(gameId);

        long total = hitMapper.countByExample(example);
        PageHelper.startPage(currentPage, limit);
        List<ViewCardUserHit> all = hitMapper.selectByExample(example);

        return new PageBean<>(currentPage, limit, total, all);
    }
}
