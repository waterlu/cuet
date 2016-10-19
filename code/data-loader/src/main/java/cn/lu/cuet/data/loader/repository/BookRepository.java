package cn.lu.cuet.data.loader.repository;


import cn.lu.cuet.data.loader.entities.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by mofang on 18/10/16.
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

}
