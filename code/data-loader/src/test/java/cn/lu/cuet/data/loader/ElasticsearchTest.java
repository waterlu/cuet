package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.entities.CareerObjective;
import cn.lu.cuet.data.loader.entities.Resume;
import cn.lu.cuet.data.loader.entities.WorkExperience;
import cn.lu.cuet.data.loader.service.ResumeService;
import cn.lu.cuet.util.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        testBatchCreateResume();
//        testGetResume();
//        testSearchResume();
    }

    private void testSearchResume() throws Exception {

    }

    private Map<String, Integer> initSkills() {
        Map<String, Integer> skills = new HashMap<>();
        try {
            Pattern pattern = Pattern.compile("(\\w+)\\((\\d+)\\)");
            FileReader fileReader = new FileReader("/home/mofang/github/cuet/code/data-loader/src/test/resources/skill.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while(null != line) {
                String skill = null;
                Integer weight = 0;
                Matcher matcher = pattern.matcher(line);
                while(matcher.find())
                {
                    skill = matcher.group(1);
                    weight = Integer.parseInt(matcher.group(2));
                }
                if (skill == null || weight == 0) {
                    line = reader.readLine();
                    continue;
                }

                if (skills.containsKey(skill)) {
                    int initWeight = skills.get(skill);
                    skills.put(skill, initWeight + weight);
                } else {
                    skills.put(skill, weight);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skills;
    }

    private void testBatchCreateResume() throws Exception {

        String POSITION[] = {".Net", "Android", "C", "C++", "C#", "Cocos2dx", "Erlang", "Flash", "Golang", "Hadoop",
                "HTML5", "IOS", "Java", "Javascript", "Node.js", "Perl", "PHP", "Python", "Ruby", "U3D", "Web", "WP" };
        String COMPANY[] = {"Google", "Youtube", "Facebook", "Baidu", "Alibaba", "Yahoo", "Twitter", "Amazon",
                "Tencent", "LinkedIn", "Jingdong", "Sina", "360", "Suning", "Netease", "Xiaomi", "Ctrip", "VIP", "Sohu"};
        Map<String, Integer> skills = initSkills();
        String skillName[] = new String[skills.size()];
        int skillWeight[] = new int[skills.size()];
        int index = 0;
        int sum = 0;
        for (Map.Entry<String, Integer> entry : skills.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            sum += value;
            skillName[index] = key;
            skillWeight[index] = sum;
            index++;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();

        long base = 100000;
//        long base = 0;
        int count = 1000;

        for(int i=0; i<count; i++) {
            long userId = base + i + 1;

            int birthYear = RandomUtil.getRandom(1980, 1995);
            int birthMonth = RandomUtil.getRandom(1, 13);
            int birthDay = RandomUtil.getRandom(1, 29);

            calendar.set(birthYear, birthMonth, birthDay);
            String birthDate = formatter.format(calendar.getTime());

            int workYear = birthYear;
            int education = RandomUtil.getRandom(1, Constant.EDUCATION_COUNT);
            if (education <= Constant.EDUCATION_HIGH_SCHOOL) {
                workYear += 18;
            } else if (education <= Constant.EDUCATION_BACHELOR){
                workYear += 22;
            } else if (education <= Constant.EDUCATION_MASTER){
                workYear += 25;
            } else {
                workYear += 28;
            }
            if (workYear > 2015) {
                workYear = 2015;
            }
            int workMonth = RandomUtil.getRandom(1, 13);
            calendar.set(workYear, workMonth, 1);
            String workDate = formatter.format(calendar.getTime());

            int gender = RandomUtil.getRandom(0, Constant.GENDER_COUNT);

            String province = String.format("%02d", RandomUtil.getRandom(1, 31));
            String city = String.format("%02d", RandomUtil.getRandom(1, 16));
            String district = String.format("%02d", RandomUtil.getRandom(1, 10));
            String location = province + city + district;

            Resume resume = new Resume();
            resume.setId("resume_" + userId);
            resume.setUserId(userId);
            resume.setBirthDate(birthDate);
            resume.setJoinWorkDate(workDate);
            resume.setEducation(education);
            resume.setGender(gender);
            resume.setLocation(location);

            CareerObjective objective = new CareerObjective();

            String category1 = String.format("%02d", RandomUtil.getRandom(1, 17));
            String category2 = String.format("%02d", RandomUtil.getRandom(1, 10));
            String category3 = String.format("%02d", RandomUtil.getRandom(1, 31));
            String category = category1 + category2 + category3;

            int industry = RandomUtil.getRandom(1, Constant.INDUSTRY_COUNT);
            float minSalray = RandomUtil.getRandom(3, 8);
            float maxSalray = RandomUtil.getRandom(8, 16);

            int status = RandomUtil.getRandom(1, Constant.OBJECTIVE_STATUS_COUNT);
            int jobType = RandomUtil.getRandom(1, Constant.OBJECTIVE_TYPE_COUNT);

            String position = POSITION[RandomUtil.getRandom(0, POSITION.length)];

            objective.setLocation(location);
            objective.setCategory(category);
            objective.setIndustry(industry);
            objective.setMinSalary(minSalray);
            objective.setMaxSalary(maxSalray);
            objective.setStatus(status);
            objective.setJobType(jobType);
            objective.setPosition(position);
            resume.setCareerObjective(objective);

            WorkExperience workExperience = new WorkExperience();
            calendar.set(workYear, workMonth, 1);
            int min = (int)minSalray;
            int max = (int)maxSalray;
            int salary = RandomUtil.getRandom(min, max);
            String company = COMPANY[RandomUtil.getRandom(0, COMPANY.length)];

            workExperience.setWorkStartTime(formatter2.format(calendar.getTime()));
            workExperience.setWorkEndTime(formatter2.format(new Date()));
            workExperience.setIndustry(industry);
            workExperience.setCategory(category);
            workExperience.setSalary(salary);
            workExperience.setCompany(company);

            StringBuffer desc = new StringBuffer("");
            int skillCount = RandomUtil.getRandom(5, 10);
            for(int j=0; j < skillCount; j++) {
                int v = RandomUtil.getRandom(0, skillWeight[skillWeight.length - 1]);
                for (int k=0; k<skillWeight.length; k++) {
                    if (v < skillWeight[k]) {
                        if (desc.toString().indexOf(skillName[k]) == -1) {
                            desc.append(skillName[k]);
                            break;
                        }
                    }
                }
                desc.append(" ");
            }

            String workDesc = desc.toString();
            workExperience.setWorkDesc(workDesc);
            resume.addWorkExperience(workExperience);

            resume = resumeService.createResume(resume);
            logger.info("resume[" + (i+1) + "]=" + resume.toString());
        }
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
        objective.setMaxSalary(10f);
        objective.setMinSalary(5f);
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