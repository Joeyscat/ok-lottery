package fun.oook.lottery.api.controller;

import fun.oook.lottery.api.service.CardGameService;
import fun.oook.lottery.api.service.ViewCardUserHitService;
import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.db.entity.CardProductDTO;
import fun.oook.lottery.commons.db.entity.ViewCardUserHit;
import fun.oook.lottery.commons.util.ApiResult;
import fun.oook.lottery.commons.util.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/game")
@Api(tags = {"活动模块"})
public class GameController {

    @Resource
    private CardGameService cardGameService;

    @Resource
    private ViewCardUserHitService hitService;

    @GetMapping("/list/{status}/{cur_page}/{limit}")
    @ApiOperation(value = "活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "活动状态(-1=全部，0=未开始，1=进行中，2=已结束)", example = "-1", required = true),
            @ApiImplicitParam(name = "cur_page", value = "第几页", defaultValue = "1", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", dataType = "int", example = "3", required = true)
    })
    public ApiResult<PageBean<CardGame>> list(@PathVariable int status, @PathVariable("cur_page") int currentPage, @PathVariable int limit) {

        return new ApiResult<>(1, "成功", cardGameService.listByStatus(status, currentPage, limit));
    }

    @GetMapping("/info/{game_id}")
    @ApiOperation(value = "活动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "game_id", value = "活动id", example = "1", required = true)
    })
    public ApiResult<CardGame> info(@PathVariable("game_id") int gameId) {
        return new ApiResult<>(1, "成功", cardGameService.selectByGameId(gameId));
    }

    @GetMapping("/products/{game_id}")
    @ApiOperation(value = "奖品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "game_id", value = "活动id", example = "1", required = true)
    })
    public ApiResult<List<CardProductDTO>> products(@PathVariable("game_id") int gameId) {
        return new ApiResult<>(1, "成功", cardGameService.productDTOS(gameId));
    }

    @GetMapping("/hit/{game_id}/{cur_page}/{limit}")
    @ApiOperation(value = "中奖列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "game_id", value = "活动id", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "cur_page", value = "第几页", defaultValue = "1", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", dataType = "int", example = "3", required = true)
    })
    public ApiResult<PageBean<ViewCardUserHit>> hit(@PathVariable("game_id") int gameId, @PathVariable("cur_page") int currentPage, @PathVariable int limit) {
        final PageBean<ViewCardUserHit> pageBean = hitService.listByGameId(gameId, currentPage, limit);

        return new ApiResult<>(1, "成功", pageBean);
    }

}
