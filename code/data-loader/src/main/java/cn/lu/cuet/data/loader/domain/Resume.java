package cn.lu.cuet.data.loader.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mofang on 17/10/16.
 */
@Document(indexName = "resume", type = "online")
public class Resume {
    @Id
    private String id;

    //
    private Long userId;

    private Integer gender;

    private Integer education;

//    private Date birthDate;
//
//    private Date joinWorkDate;

    private String birthDate;

    private String joinWorkDate;

    private String location;

    @Field(type = FieldType.Nested)
    private CareerObjective careerObjective;

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    @Field(type = FieldType.Nested)
    private List<WorkExperience> workExperienceList = new ArrayList<>();
//    private WorkExperience workExperienceList;



    public boolean addWorkExperience(WorkExperience workExperience) {
//        this.workExperienceList = workExperience;
//        return true;
        return workExperienceList.add(workExperience);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public Date getJoinWorkDate() {
//        return joinWorkDate;
//    }
//
//    public void setJoinWorkDate(Date joinWorkDate) {
//        this.joinWorkDate = joinWorkDate;
//    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getJoinWorkDate() {
        return joinWorkDate;
    }

    public void setJoinWorkDate(String joinWorkDate) {
        this.joinWorkDate = joinWorkDate;
    }

    public CareerObjective getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(CareerObjective careerObjective) {
        this.careerObjective = careerObjective;
    }


    @Override
    public String toString() {
        return "Resume{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", gender=" + gender +
                ", education=" + education +
                ", birthDate='" + birthDate + '\'' +
                ", joinWorkDate='" + joinWorkDate + '\'' +
                ", location='" + location + '\'' +
                ", careerObjective=" + careerObjective +
                ", workExperienceList=" + workExperienceList +
                '}';
    }
}
