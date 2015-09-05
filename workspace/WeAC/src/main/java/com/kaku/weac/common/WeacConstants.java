package com.kaku.weac.common;

/**
 * 公共常量类
 *
 * @author 咖枯
 * @version 1.0 2015
 */
public class WeacConstants {

    /**
     * SharedPreferences属性信息文件
     */
    public static final String EXTRA_WEAC_SHARE = "extra_weac_shared_preferences_file";

    /**
     * 保存的壁纸ID
     */
    public static final String WALLPAPER_ID = "wallpaper_id";

    /**
     * 保存的壁纸位置
     */
    public static final String WALLPAPER_POSITION = "wallpaper_position";

    /**
     * 铃声名
     */
    public static final String RING_NAME = "ring_name";

    /**
     * 保存的AlarmClock单例
     */
    public static final String ALARM_CLOCK = "alarm_clock";

    /**
     * 铃声地址
     */
    public static final String RING_URL = "ring_url";

    /**
     * 铃声选择界面位置
     */
    public static final String RING_PAGER = "ring_pager_position";

    /**
     * 默认铃声Url标记
     */
    public static final String DEFAULT_RING_URL = "default_ring_url";

    /**
     * 无铃声Url标记
     */

    public static final String NO_RING_URL = "no_ring_url";

    /**
     * 小睡重复次数
     */
    public static final String NAP_TIMES = "nap_times";

    /**
     * 小睡已执行次数
     */
    public static final String NAP_RAN_TIMES = "nap_ran_times";

    /**
     * 小睡间隔
     */
    public static final String NAP_INTERVAL = "nap_interval";

    /**
     * 位置
     */
    public static final String POSITION = "position";

    /**
     * 类型(1：重命名，2：删除，3：批量删除，4：详情）
     */
    public static final String TYPE = "type";

    /**
     * 新文件Url
     */
    public static final String NEW_URL = "url_new";

    /**
     * 最大录音时常10分钟
     */
    public static final int MAX_RECORD_LENGTH = 1000 * 60 * 10;
}