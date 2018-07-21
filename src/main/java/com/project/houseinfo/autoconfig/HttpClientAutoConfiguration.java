package com.project.houseinfo.autoconfig;

import org.apache.http.client.HttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * Created By 胡玉国 on 2018/7/17
 */
@Configuration
@ConditionalOnClass({HttpClient.class})
public class HttpClientAutoConfiguration {

}
