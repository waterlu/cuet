package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.config.MybatisConfiguration;
import cn.lu.cuet.data.loader.mapper.ResumeMapper;
import cn.lu.cuet.data.loader.model.Education;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by lu on 16-10-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataLoaderApplication.class)
//@Transactional
//@SpringApplicationConfiguration(DataLoaderApplication.class)
public class MybatisTest {

    private Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private ResumeMapper resumeMapper;

    @Test
    public void testCreateResume() throws Exception {
//        for (int i=0; i<10; i++) {
            Resume resume = new Resume();
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

            Education education;

            education = new Education();
            education.setCollege("Oxford");
            education.setDegree(1);
            education.setMajor("Computer");
            education.setStart("2000");
            education.setEnd("2004");
            resume.addEducation(education);

            education = new Education();
            education.setCollege("Oxford");
            education.setDegree(2);
            education.setMajor("Computer");
            education.setStart("2004");
            education.setEnd("2007");
            resume.addEducation(education);

            resume.prepare();

            resumeMapper.createResume(resume);
            long id = resume.getId();
            logger.info("generate id is " + id);
            assert (id > 0);
//        }
    }
}
