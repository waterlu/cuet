package cn.lu.cuet.data.loader.entities;

/**
 * Created by mofang on 19/10/16.
 */
public class MFCompany {

    private String name;

    private String desc;

    private String position;

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MFCompany{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
