package com.kenzie.appserver.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableDynamoDBRepositories
        (basePackages = "com.kenzie.appserver.repositories")
public class DynamoDbConfig {

    @Value("${dynamodb.override_endpoint}")
    String dynamoOverrideEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey = "ASIA3R6MLLK5LJB4KK6S";

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey = "oBzFMMTwhxx4+vyFt16QfLeEgM3Dok6a04LlF4OJ";

    @Bean
    @ConditionalOnProperty(name = "dynamodb.override_endpoint", havingValue = "true")
    public AmazonDynamoDB amazonDynamoDB(AWSCredentials AWSCredentials,
                                         @Value("${dynamodb.endpoint}") String dynamoEndpoint) {

        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoEndpoint, "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(AWSCredentials));

        return builder.build();
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                amazonAWSAccessKey, amazonAWSSecretKey);
    }
}

//@Configuration
//@EnableDynamoDBRepositories(basePackages = "com.kenzie.appserver.repositories")
//public class DynamoDbConfig {
//    @Value("${dynamodb.override_endpoint}")
//    String dynamoOverrideEndpoint;
//
//    @Value("${amazon.aws.accesskey}")
//    private String amazonAWSAccessKey = "ASIA3R6MLLK5NNANS2WL";
//
//    @Value("${amazon.aws.secretkey}")
//    private String amazonAWSSecretKey = "jVBDmwJ5No/PfzOifezCCVDcKPgMX7iJOIqvs3Od";
//    @Bean
//    @ConditionalOnProperty(name = "dynamodb.override_endpoint", havingValue = "true")
//    public AmazonDynamoDB amazonDynamoDB(@Value("${dynamodb.endpoint}") String dynamoEndpoint) {
//        AwsClientBuilder.EndpointConfiguration endpointConfig = new
//                AwsClientBuilder.EndpointConfiguration(dynamoEndpoint,
//                "us-east-1");
//
//        return AmazonDynamoDBClientBuilder
//                .standard()
//                .withEndpointConfiguration(endpointConfig)
//                .build();
//
//    }
//
//    @Bean(name = "amazonDynamoDB")
//    public AmazonDynamoDB defaultAmazonDynamoDb() {
//        return AmazonDynamoDBClientBuilder.defaultClient();
//    }

