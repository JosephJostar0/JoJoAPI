package com.zuel.backend.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CheckApiUsing implements Serializable {
    private String accessKey;
    private String apiPath;
}
