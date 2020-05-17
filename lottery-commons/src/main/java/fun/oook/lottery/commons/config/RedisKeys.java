package fun.oook.lottery.commons.config;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public class RedisKeys {
    /**
     * 活动信息
     */
    public static final String GAME_INFO = "game_info_";
    /**
     * 令牌前缀
     */
    public static final String GAME_TOKEN = "game_token_";
    /**
     * 令牌桶key
     */
    public static final String GAME_TOKENS = "game_tokens_";
    /**
     * 最大中奖数
     */
    public static final String GAME_MAX_GOAL = "game_max_goal_";
    /**
     * 最大抽奖数
     */
    public static final String GAME_MAX_ENTER = "game_max_enter";


    /**
     * redis session
     */
    public static final String USER_SESSION_ID = "user_session_id_";
    /**
     * 用户中奖数
     */
    public static final String USER_HIT = "user_hit_";
    /**
     * 用户登录错误次数
     */
    public static final String USER_LOGIN_TIMES = "user_login_times_";
    /**
     * 用户是否参与该活动
     */
    public static final String USER_GAME = "user_game_";


}
