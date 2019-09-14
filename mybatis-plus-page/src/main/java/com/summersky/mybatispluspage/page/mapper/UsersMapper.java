package com.summersky.mybatispluspage.page.mapper;

import com.summersky.mybatispluspage.page.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 王者英雄排行 Mapper 接口
 * </p>
 *
 * @author zengfanbin
 * @since 2019-09-10
 */
@Component
public interface UsersMapper extends BaseMapper<Users> {
    @Select("SELECT job,COUNT(job) FROM `king_users` GROUP BY `job`;")
    List<Users> groupliist();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"刺客\";")
    Integer cike();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"法师\";")
    Integer fashi();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"坦克\";")
    Integer tanke();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"射手\";")
    Integer sheshou();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"战士\";")
    Integer zhanshi();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"侠岚\";")
    Integer xialan();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"辅助\";")
    Integer fuzhu();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"零\";")
    Integer ling();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"魂族\";")
    Integer hunzu();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"古族\";")
    Integer guzu();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"萧族\";")
    Integer xiaozu();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"太虚古龙\";")
    Integer txgl();
    @Select("SELECT COUNT(job) FROM `king_users` WHERE `job`=\"异火\";")
    Integer yihuo();
}
