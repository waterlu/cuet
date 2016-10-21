package cn.lu.cuet.data.loader.service;

import cn.lu.cuet.data.loader.entities.MFResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

/**
 * Created by mofang on 20/10/16.
 */
public interface SearchService {

    Iterable<MFResume> queryAll();

}
