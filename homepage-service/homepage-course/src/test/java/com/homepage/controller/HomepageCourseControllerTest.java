package com.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.homepage.CourseInfosRequest;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/get/course")
                //判断返回结果是否为json
                .accept(MediaType.APPLICATION_JSON)
                .param("id", String.valueOf(1)))
                //对返回的code进行判断
                .andExpect(MockMvcResultMatchers.status().isOk())

                //对输出的内容比较，
                //.andExpect(MockMvcResultMatchers.content().string("ii"));
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        //result:
        // {"id":1,"courseName":"JDK新","courseType":"免费","courseIcon":"http","courseIntro":"learn"}
        System.out.println("result: " + contentAsString);

    }

    //test post
    @Test
    public void getCourseInfos() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);

        CourseInfosRequest request = new CourseInfosRequest();
        request.setIds(list);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/get/courses")
                .contentType(MediaType.APPLICATION_JSON_UTF8)

                .content(JSON.toJSONString(request))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())//MockMvcResultHandlers: 打印请求的信息
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();

        System.out.println("post: " + contentAsString);


    }
}