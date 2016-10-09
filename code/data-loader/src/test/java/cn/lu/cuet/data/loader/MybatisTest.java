package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.config.MybatisConfiguration;
import cn.lu.cuet.data.loader.mapper.ResumeMapper;
import cn.lu.cuet.data.loader.model.Resume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by lu on 16-10-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = MybatisConfiguration.class)
@SpringApplicationConfiguration(DataLoaderApplication.class)
public class MybatisTest {

    private Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private ResumeMapper resumeMapper;

    @Test
    public void testCreateResume() throws Exception {
        Resume resume = new Resume();
        resume.setId(1001l);
        resume.setCreateTime(new Date());
        resume.setUpdateTime(new Date());
        resume.setDeleted(0);
        resume.setBirthday(new Date());
        resume.setCity("01");
        resume.setDegree(1);
        resume.setEmail("12345678@qq.com");
        resume.setGender(1);
        resume.setHukou("Beijing");
        resume.setIntroduction("Introduction");
        resume.setMaritalStatus(1);
        resume.setMobile("13800138000");
        resume.setName("Tom");
        resume.setProvince("01");
        resume.setQq("12345678");
        resume.setResumeName("english resume");
        resume.setSource(1);
        resume.setUserId(100001l);
        resume.setWorkExperience(1);
        resume.setZone("01");
        resumeMapper.createResume(resume);
    }
}
