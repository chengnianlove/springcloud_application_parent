package com.cheng.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author create by chengnian On 2021/10/22 16:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "person")
public class Person {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field(value = "age")
    private int age;
}
