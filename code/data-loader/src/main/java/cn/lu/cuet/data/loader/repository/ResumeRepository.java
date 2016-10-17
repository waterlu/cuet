package cn.lu.cuet.data.loader.repository;

import cn.lu.cuet.data.loader.domain.Resume;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by lutiehua on 17/10/16.
 */
public interface ResumeRepository extends ElasticsearchRepository<Resume, Long> {

    List<Resume> findByUserId(Long userId);

}
