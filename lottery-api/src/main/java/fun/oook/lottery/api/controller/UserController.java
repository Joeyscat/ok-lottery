package fun.oook.lottery.api.controller;

import fun.oook.lottery.api.service.UserService;
import fun.oook.lottery.commons.db.entity.CardUserDTO;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "用户模块",tags = "用户模块")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/info")
    @ApiOperation(value = "用户信息")
    public ApiResult<CardUserDTO> info(final HttpServletRequest req) {
        final HttpSession session = req.getSession();

        final CardUserDTO userDTO = userService.info(session.getId());
        if (userDTO == null) {
            return new ApiResult<>(0, "登录超时", null);
        }
        return new ApiResult<>(1, "成功", userDTO);
    }


    @GetMapping("/hit/{game_id}/{cur_page}/{limit}")
    @ApiOperation("我的奖品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "game_id", value = "活动id（-1=全部）", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "cur_page", value = "第几页", defaultValue = "1", dataType = "int", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", dataType = "int", example = "3")
    })
    public ApiResult<PageBean<ViewCardUserHit>> hit(@PathVariable("game_id") int gameId, @PathVariable("cur_page") int curPage,
                                                    @PathVariable int limit, HttpServletRequest req) {
        final Integer userId = (Integer) req.getSession().getAttribute("loginUserId");
        if (userId == null) {
            return new ApiResult<>(0, "登录超时", null);
        }
        final PageBean<ViewCardUserHit> hit = userService.hit(gameId, curPage, limit, userId);
        return new ApiResult<>(1, "成功", hit);
    }

}
