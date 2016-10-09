package cn.lu.cuet.data.loader.service.impl;

import cn.lu.cuet.data.loader.mapper.ResumeMapper;
import cn.lu.cuet.data.loader.model.Resume;
import cn.lu.cuet.data.loader.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lu on 16-10-8.
 */
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public Resume findResumeById(long id) {
        return resumeMapper.findResumeById(id);
    }
}
