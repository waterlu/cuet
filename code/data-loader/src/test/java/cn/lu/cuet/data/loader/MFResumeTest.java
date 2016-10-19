package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.entities.*;
import cn.lu.cuet.data.loader.repository.MFResumeRepository;
import cn.lu.cuet.data.loader.service.ResumeService;
import cn.lu.cuet.util.Constant;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by mofang on 19/10/16.
 */
public class MFResumeTest {
    private Logger logger = LoggerFactory.getLogger(MFResumeTest.class);

    @Autowired
    private MFResumeRepository mfResumeRepository;

    @Test
    public void testAll() throws Exception{
        testCreateResume();
    }

    private void testCreateResume() throws Exception {
        MFResume resume = null;
        MFObjective objective = null;
        MFWorkExp workExp = null;
        MFCompany company = null;

        // 1
        resume = new MFResume();
        resume.setAvailable(true);
        resume.setBirthDate("1982-05-01");
        resume.setEducation(Constant.EDUCATION_HIGH_SCHOOL);
        resume.setGender(Constant.GENDER_MALE);
        resume.setId(1L);
        resume.setName("李星星");
        objective = new MFObjective();
        objective.setStatus(Constant.OBJECTIVE_STATUS_SEEK_JOB);
        objective.setPosition("软件工程师");
        objective.setCategory("后端开发开");
        objective.setCity("");
        objective.setSalary(Constant.SALARY_4_6);
        resume.setObjective(objective);
        resume.setUserId(1L);
        workExp = new MFWorkExp();
        company = new MFCompany();
        company.setName("金科博悦");
        company.setPosition("信息技术专员");
        company.setDesc("java开");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("知通网");
        company.setPosition("客户代表");
        company.setDesc("主要从事企事业单位的第三方服务公司，通过各种形式于客户达成合作，为客户提供公司建站，线上销售，企业招投标等服务。");
        workExp.addCompany(company);
        resume.setWorkExp(workExp);
        resume = mfResumeRepository.save(resume);
        logger.info("resume[1]=" + resume.toString());

        // 2
        resume = new MFResume();
        resume.setAvailable(true);
        resume.setBirthDate("1982-05-01");
        resume.setEducation(Constant.EDUCATION_HIGH_SCHOOL);
        resume.setGender(Constant.GENDER_MALE);
        resume.setId(1L);
        resume.setName("李星星");
        objective = new MFObjective();
        objective.setStatus(Constant.OBJECTIVE_STATUS_SEEK_JOB);
        objective.setPosition("软件工程师");
        objective.setCategory("后端开发开");
        objective.setCity("");
        objective.setSalary(Constant.SALARY_4_6);
        resume.setObjective(objective);
        resume.setUserId(1L);
        workExp = new MFWorkExp();
        company = new MFCompany();
        company.setName("金科博悦");
        company.setPosition("信息技术专员");
        company.setDesc("java开");
        workExp.addCompany(company);
        company = new MFCompany();
        company.setName("知通网");
        company.setPosition("客户代表");
        company.setDesc("主要从事企事业单位的第三方服务公司，通过各种形式于客户达成合作，为客户提供公司建站，线上销售，企业招投标等服务。");
        workExp.addCompany(company);
        resume.setWorkExp(workExp);
        resume = mfResumeRepository.save(resume);
        logger.info("resume[1]=" + resume.toString());
    }
}
