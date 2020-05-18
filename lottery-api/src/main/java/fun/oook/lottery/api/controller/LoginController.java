package fun.oook.lottery.api.controller;

import fun.oook.lottery.api.service.UserService;
import fun.oook.lottery.commons.db.entity.CardUser;
import fun.oook.lottery.commons.util.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(tags = "登录模块")
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public ApiResult<CardUser> login(HttpServletRequest req, @RequestParam String account, @RequestParam String password) {
        return userService.login(account, password, req.getSession());
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出")
    public ApiResult<Object> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            final String loginUserId = (String) session.getAttribute("loginUserId");
            userService.logout(loginUserId);
            session.invalidate();
        }
        return new ApiResult<>(1, "退出成功", null);
    }
}
