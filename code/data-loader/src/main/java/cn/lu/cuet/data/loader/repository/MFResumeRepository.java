package cn.lu.cuet.data.loader.repository;

import cn.lu.cuet.data.loader.entities.MFResume;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by mofang on 19/10/16.
 */
public interface MFResumeRepository extends ElasticsearchRepository<MFResume, Long> {

}
