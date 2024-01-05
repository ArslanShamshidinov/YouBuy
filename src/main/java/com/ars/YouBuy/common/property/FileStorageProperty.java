package com.ars.YouBuy.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "file")
public class FileStorageProperty {

    private String uploadDir;

}