package com.cheng.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author create by chengnian On 2021/10/22 9:07
 */
@Component
@RequestMapping("es")
public class EsDemo {

//    @Autowired
//    @Qualifier("elasticsearchClient")
//    private RestHighLevelClient restHighLevelClient;

//    @Autowired
//    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @RequestMapping("/test.do")
    public void test() throws IOException{
        SearchRequest searchRequest = new SearchRequest("shopping");

        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setIndexName("cheng_index");
        indexQuery.setId("1");
        indexQuery.setType("text");
        elasticsearchRestTemplate.index(indexQuery);

        RequestOptions options = RequestOptions.DEFAULT;
        options.toBuilder().addHeader("", "");
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, options);
//        SearchHits hits = searchResponse.getHits();

        elasticsearchRestTemplate.createIndex("shopping");

        Map map = elasticsearchRestTemplate.queryForObject(GetQuery.getById(""), Map.class);

        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("age")
                .lte(12).gte(35);
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        List<Map> mapList = elasticsearchRestTemplate.multiGet(searchQuery, Map.class);

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("");

    }
}
