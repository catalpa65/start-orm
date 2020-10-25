package com.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.dao.UserMapper;
import com.sys.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class StartOrmApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setAge(6);
        user.setCreateTime(LocalDateTime.now());
        user.setManagerId(1087982257332887553L);
        user.setUserName("haha");
        user.setRemark("111");

        int rows = userMapper.insert(user);
        System.out.println("---影响行数 " + rows);
    }

    @Test
    public void select() {
        System.out.println(userMapper.selectById(1087982257332887553L));
    }

    @Test
    public void selects() {
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1087982257332887553L, 1088248166370832385L));
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王天风");
        map.put("age", "28");
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40));
    }

    @Test
    public void selectByWrapper1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王");
        userMapper.selectAll(queryWrapper);
    }

    @Test
    public void selectPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 26);

        Page<User> page = new Page<>(1, 2);
        /*IPage<User> iPage = userMapper.selectPage(page, queryWrapper);

        System.out.println(iPage.getPages() + " " + iPage.getTotal());
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);*/

        /*IPage<Map<String, Object>> iPage = userMapper.selectMapsPage(page, queryWrapper);

        System.out.println(iPage.getPages() + " " + iPage.getTotal());
        List<Map<String, Object>> userList = iPage.getRecords();
        userList.forEach(System.out::println);*/

        IPage<User> iPage = userMapper.selectUserPage(page, queryWrapper);

        System.out.println(iPage.getPages() + " " + iPage.getTotal());
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

    @Test
    public void insertAR() {
        User user = new User();
        user.setUserName("Tom");
        user.setRemark("AR");
        user.insert();
    }

}
