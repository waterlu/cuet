package cn.lu.cuet.data.capture.model;

import java.util.Date;

/**
 * Created by lu on 16-10-9.
 */
public class Resume extends DBModel {

    // 所属用户
    private String userId;

    // 姓名
    private String name;

    // 性别
    private Integer gender;

    // 出生日期
    private Date birthday;

    // 婚姻状态
    private Integer maritalStatus;

    // 手机号码
    private String mobile;

    // 邮箱
    private String email;

    // QQ号码
    private String qq;

    // 户籍
    private String hukou;

    // 所地在-省
    private String province;

    // 所在地-市
    private String city;

    // 所在地-区
    private String area;

    // 工作经验
    private Integer workExperience;

    // 最高学历
    private Integer degree;

    // 简历来源
    private Integer resumeSource;

    // 简历名称
    private String resumeName;

    // 自我介绍
    private String introduction;

//    // 求职意向
//    private Objective objective;
//
//    // 工作经历
//    private Career career;
//
//    // 教育经历
//    private Education education;
//
//    // 项目经验
//    private Project project;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHukou() {
        return hukou;
    }

    public void setHukou(String hukou) {
        this.hukou = hukou;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getResumeSource() {
        return resumeSource;
    }

    public void setResumeSource(Integer resumeSource) {
        this.resumeSource = resumeSource;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

//    public Objective getObjective() {
//        return objective;
//    }
//
//    public void setObjective(Objective objective) {
//        this.objective = objective;
//    }
//
//    public Career getCareer() {
//        return career;
//    }
//
//    public void setCareer(Career career) {
//        this.career = career;
//    }
//
//    public Education getEducation() {
//        return education;
//    }
//
//    public void setEducation(Education education) {
//        this.education = education;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
}
