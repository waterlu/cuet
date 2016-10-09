package cn.lu.cuet.data.loader.mapper;

import cn.lu.cuet.data.loader.model.Resume;

/**
 * Created by lu on 16-10-8.
 */
public interface ResumeMapper {

    void createResume(Resume resume);

    Resume findResumeById(long id);

}
