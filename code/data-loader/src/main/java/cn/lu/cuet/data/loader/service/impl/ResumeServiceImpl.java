package cn.lu.cuet.data.loader.service.impl;

import cn.lu.cuet.data.loader.entities.Resume;
import cn.lu.cuet.data.loader.repository.ResumeRepository;
import cn.lu.cuet.data.loader.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mofang on 17/10/16.
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public void deleteResume(Resume resume) {
        resumeRepository.delete(resume);
    }

    @Override
    public long count() {
        return resumeRepository.count();
    }

    @Override
    public List<Resume> findByUserId(Long userId) {
        return resumeRepository.findByUserId(userId);
    }



}
