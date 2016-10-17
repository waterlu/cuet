package cn.lu.cuet.data.loader.domain;

/**
 * Created by lutiehua on 17/10/16.
 */
public class WorkExperience {

    private String workStartTime;

    private String workEndTime;

    private String category;

    private String position;

    private String positionDesc;

    private String workDesc;

    private Integer salary;

    private Integer industry;

    private String company;

    private String department;

    private Integer scale;

    private Integer character;


    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getCharacter() {
        return character;
    }

    public void setCharacter(Integer character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workStartTime='" + workStartTime + '\'' +
                ", workEndTime='" + workEndTime + '\'' +
                ", category='" + category + '\'' +
                ", position='" + position + '\'' +
                ", positionDesc='" + positionDesc + '\'' +
                ", workDesc='" + workDesc + '\'' +
                ", salary=" + salary +
                ", industry='" + industry + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", scale=" + scale +
                ", character=" + character +
                '}';
    }
}
