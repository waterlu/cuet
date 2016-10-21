package cn.lu.cuet.data.loader.api;

import cn.lu.cuet.data.loader.entities.MFResume;
import cn.lu.cuet.data.loader.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mofang on 20/10/16.
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/all")
    public Iterable<MFResume> queryAll() {
        return searchService.queryAll();
    }

}
