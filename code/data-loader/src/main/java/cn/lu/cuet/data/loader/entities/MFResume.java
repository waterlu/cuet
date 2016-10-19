package cn.lu.cuet.data.loader.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by mofang on 19/10/16.
 */
@Document(indexName = "mofang", type = "resume")
public class MFResume {
    @Id
    private Long id;

    private long userId;

    private String name;

    private int gender;

    private String birthDate;

    private int education;

    private boolean available;

    private MFObjective objective;

    private MFWorkExp workExp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MFObjective getObjective() {
        return objective;
    }

    public void setObjective(MFObjective objective) {
        this.objective = objective;
    }

    public MFWorkExp getWorkExp() {
        return workExp;
    }

    public void setWorkExp(MFWorkExp workExp) {
        this.workExp = workExp;
    }

    @Override
    public String toString() {
        return "MFResume{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate='" + birthDate + '\'' +
                ", education=" + education +
                ", available=" + available +
                ", objective=" + objective +
                ", workExp=" + workExp +
                '}';
    }
}
