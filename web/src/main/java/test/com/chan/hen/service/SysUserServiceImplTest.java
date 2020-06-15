package test.com.chan.hen.service;

import com.chan.hen.HenApplication;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HenApplication.class)
@WebAppConfiguration
public class SysUserServiceImplTest {

    @Autowired
    private ObjectMapper objectMapper;
    private List<SysUser> sysUsers;
    @Autowired
    private SysUserService sysUserService;

    @Before
    public void before() throws Exception {
        sysUsers=sysUserService.list();
    }
    @After
    public void after() throws Exception {
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
