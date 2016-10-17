package cn.lu.cuet.data.loader.domain;

/**
 * Created by lutiehua on 17/10/16.
 */
public class CareerObjective {

    private Integer status;

    private Double minSalary;

    private Double maxSalary;

    private String location;

    private String category;

    private String position;

    private Integer jobType;

    private Integer industry;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer type) {
        this.jobType = type;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "CareerObjective{" +
                "status=" + status +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", position='" + position + '\'' +
                ", jobType=" + jobType +
                ", industry=" + industry +
                '}';
    }
}
