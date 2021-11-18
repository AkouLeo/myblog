package com.cx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.entity.User;
import com.cx.mapper.UserMapper;
import com.cx.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ChengXing
 * @Date Created in 21:59 2021/11/17
 * @Description 20211110blog
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
