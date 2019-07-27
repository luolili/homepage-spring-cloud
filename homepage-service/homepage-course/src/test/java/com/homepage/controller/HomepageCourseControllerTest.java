package com.homepage.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * api test： 默认 打包的时候会自动执行test case
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomepageCourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCourseInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/get/course"))
                //对返回的code进行判断
                .andExpect(MockMvcResultMatchers.status().isOk())
                //对输出的内容比较，
                .andExpect(MockMvcResultMatchers.content().string("ii"));
    }
}