package cn.lu.cuet.data.loader.entities;

import java.util.List;

/**
 * Created by mofang on 19/10/16.
 */
public class MFWorkExp {

    private List<MFCompany> companyList;

    public List<MFCompany> getCompanyList() {
        return companyList;
    }

    public void addCompany(MFCompany company) {
        this.companyList.add(company);
    }

    @Override
    public String toString() {
        return "MFWorkExp{" +
                "companyList=" + companyList +
                '}';
    }
}
