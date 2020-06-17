package test.com.chan.hen.service;

import com.chan.hen.HenApplication;
import com.chan.hen.controller.SysUserController;
import com.chan.hen.entity.SysUser;
import com.chan.hen.service.SysUserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HenApplication.class)
@WebAppConfiguration
public class SysUserServiceImplTest {


    @Autowired
    private ObjectMapper objectMapper;
    private List<SysUser> sysUsers;
    @Autowired
    private SysUserService sysUserService;


    private MockMvc mockMvc;
    @Autowired
    private SysUserController sysUserController;

    @Before
    public void before() throws Exception {
        sysUsers=sysUserService.list();
        mockMvc= MockMvcBuilders.standaloneSetup(sysUserController).build();
    }
    @After
    public void after() throws Exception {
    }
    @Test
    public void testUserController() throws Exception {
        // 测试
        RequestBuilder request;

        // 1、get查一下user列表，应该为空
        request = get("/sysUser/");
        mockMvc.perform(request)
                .andExpect(status().isOk());

        // 2、post提交一个user
        request = post("/sysUser/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"admin\",\"age\":20}");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/sysUser/");
        mockMvc.perform(request)
                .andExpect(status().isOk());

        // 4、put修改id为1的user
        request = put("/sysUser/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"administrator\",\"age\":30}");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        request = get("/sysUser/1");
        mockMvc.perform(request);

        // 6、del删除id为1的user
        request = delete("/sysUser/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = get("/sysUser/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

    @Test
    public void testJacksonList() throws Exception{
        //对象转json
        String json=objectMapper.writeValueAsString(sysUsers);
        //json 转list
        List<SysUser> list=objectMapper.readValue(json, new TypeReference<List<SysUser>>() {});
        System.out.println("");
    }
    @Test
    public void testJacksonObj() throws Exception{
        SysUser sysUser = null;
        if(sysUsers!=null&& sysUsers.size()>0){
            sysUser=sysUsers.get(0);
        }
        //对象转json
        String json=objectMapper.writeValueAsString(sysUser);
        //json 转对象
        SysUser user=objectMapper.readValue(json, SysUser.class);
        System.out.println("");
    }

}
