//package com.cheng.es;
//
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//
///**
// * @author create by chengnian On 2021/10/21 17:28
// */
//@Configuration
//public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
//
//    @Override
//    @Bean
//    public RestHighLevelClient elasticsearchClient(){
//
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("192.168.22.126:9200")
//                .build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//}
