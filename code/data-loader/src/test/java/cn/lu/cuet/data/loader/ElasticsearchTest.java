package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.domain.CareerObjective;
import cn.lu.cuet.data.loader.domain.Resume;
import cn.lu.cuet.data.loader.domain.WorkExperience;
import cn.lu.cuet.data.loader.service.ResumeService;
import cn.lu.cuet.util.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mofang on 17/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataLoaderApplication.class)
public class ElasticsearchTest {

    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest.class);

    @Autowired
    private ResumeService resumeService;

    @Test
    public void testAll() throws Exception{
//        testCreateResume();
//        testGetResume();
        testSearchResume();
    }

    private void testSearchResume() throws Exception {

    }

    private void testCreateResume() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = formatter.format(new Date());
        String workDate = formatter.format(new Date());

        Resume resume = new Resume();
        resume.setUserId(1003L);
        resume.setBirthDate(birthDate);
        resume.setEducation(1);
        resume.setGender(0);
        resume.setJoinWorkDate(workDate);
        resume.setLocation("010203");

        CareerObjective objective = new CareerObjective();
        objective.setLocation("010203");
        objective.setCategory("010203");
        objective.setIndustry(Constant.INDUSTRY_EDUCATION);
        objective.setMaxSalary(10d);
        objective.setMinSalary(5d);
        objective.setStatus(Constant.OBJECTIVE_STATUS_FOR_BETTER_JOB);
        objective.setJobType(Constant.OBJECTIVE_TYPE_FULL_JOB);
        objective.setPosition("software engineer");
        resume.setCareerObjective(objective);

        WorkExperience workExperience = new WorkExperience();
        workExperience.setWorkStartTime("2010-09");
        workExperience.setWorkEndTime("");
        workExperience.setIndustry(Constant.INDUSTRY_AUTO);
        workExperience.setCategory("010203");
        workExperience.setCompany("company name");
        workExperience.setSalary(1);
        workExperience.setWorkDesc("bala bala bala");
        resume.addWorkExperience(workExperience);
        resume.addWorkExperience(workExperience);

        resume = resumeService.createResume(resume);
        logger.info("resume=" + resume.toString());
    }

    private void testGetResume() throws Exception {
        List<Resume> resumes = resumeService.findByUserId(1003L);
        for(Resume resume : resumes) {
            logger.info("resume=" + resume.toString());
        }
    }
}