package cn.lu.cuet.data.loader.service;

import cn.lu.cuet.data.loader.entities.Resume;

import java.util.List;

/**
 * Created by mofang on 17/10/16.
 */
public interface ResumeService {

    Resume createResume(Resume resume);

    void deleteResume(Resume resume);

    long count();

    List<Resume> findByUserId(Long userId);

}
