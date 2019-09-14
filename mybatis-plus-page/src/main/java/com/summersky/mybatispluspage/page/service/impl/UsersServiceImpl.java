package com.summersky.mybatispluspage.page.service.impl;

import com.summersky.mybatispluspage.page.entity.Users;
import com.summersky.mybatispluspage.page.mapper.UsersMapper;
import com.summersky.mybatispluspage.page.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 王者英雄排行 服务实现类
 * </p>
 *
 * @author zengfanbin
 * @since 2019-09-10
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
