import com.cheng.UserApplication;
import com.cheng.es.Person;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author create by chengnian On 2021/10/22 15:46
 */
@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
class EsDemoTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testCheng(){
        /*
        IndexQuery indexQuery = new IndexQuery();
        Person person = new Person("3", "cheng nian", 28);
        indexQuery.setObject(person);
        String index = elasticsearchOperations.index(indexQuery);
        */
        /*
        List<IndexQuery> list = new ArrayList<>();

        String s = "abcdefghijklmnopqrstuvwxyz";

        int length = s.length();

        for(int i = 0; i < 10; i++) {
            IndexQuery indexQuery = new IndexQuery();
            Person person = new Person();

            double d1 = new Random().nextInt(length);
            double d2 = new Random().nextInt(length);
            double d3 = new Random().nextInt(length);

            char c1 = s.charAt((int) d1);
            char c2 = s.charAt((int) d2);
            char c3 = s.charAt((int) d3);

            person.setId(UUID.randomUUID().toString());
            person.setName(String.valueOf(c1) + c2 + c3);
            person.setAge((c1 + c2 + c3));
            indexQuery.setObject(person);
            list.add(indexQuery);
        }

        elasticsearchOperations.bulkIndex(list);
        */
/*
        GetQuery getQuery = new GetQuery();
        getQuery.setId("2709277a-aa28-40be-839f-7bf162bfc5ab");
        Person person = elasticsearchOperations.queryForObject(getQuery, Person.class);
        System.out.println(person);
        person = elasticsearchOperations.queryForObject(GetQuery.getById("2709277a-aa28-40be-839f-7bf162bfc5ab"), Person.class);
        System.out.println(person);
 */

        QueryBuilder query = new RangeQueryBuilder("age").lt(320).gt(300);
        SearchQuery searchQuery = new NativeSearchQuery(query);
        List<Person> personList = elasticsearchRestTemplate.queryForList(searchQuery, Person.class);
        System.out.println(personList);

        Page<Person> people = elasticsearchRestTemplate.queryForPage(searchQuery, Person.class);
        System.out.println(people);
    }
}
