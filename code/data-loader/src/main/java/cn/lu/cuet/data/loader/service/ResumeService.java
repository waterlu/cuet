package cn.lu.cuet.data.loader.service;

import cn.lu.cuet.data.loader.model.Resume;
import org.springframework.stereotype.Service;

/**
 * Created by lu on 16-10-8.
 */
public interface ResumeService {

    public Resume findResumeById(long id);

}
