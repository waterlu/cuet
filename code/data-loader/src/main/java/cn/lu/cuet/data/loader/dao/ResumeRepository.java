package cn.lu.cuet.data.loader.dao;

import cn.lu.cuet.data.loader.model.Resume;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by lu on 16-10-8.
 */
//public interface ResumeRepository extends ElasticsearchRepository<Resume, String> {

public interface ResumeRepository  {

    public Resume findByName(String name);

    public Resume findByMobile(String name);

}
