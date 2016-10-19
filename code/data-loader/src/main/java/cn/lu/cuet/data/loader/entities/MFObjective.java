package cn.lu.cuet.data.loader.entities;

/**
 * Created by mofang on 19/10/16.
 */
public class MFObjective {

    private Integer status;

    private String category;

    private String position;

    private Integer salary;

    private String city;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "MFObjective{" +
                "status=" + status +
                ", category='" + category + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }
}
