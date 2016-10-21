package cn.lu.cuet.data.loader.service.impl;

import cn.lu.cuet.data.loader.entities.MFResume;
import cn.lu.cuet.data.loader.repository.MFResumeRepository;
import cn.lu.cuet.data.loader.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.lang.Iterable;
import java.util.List;

/**
 * Created by mofang on 20/10/16.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MFResumeRepository mfResumeRepository;

    @Override
    public Iterable<MFResume> queryAll() {
        return mfResumeRepository.findAll();
    }

    public void queryPosition() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withFilter(boolFilter().must(termFilter("id", documentId)))
                .build();
    }
}
