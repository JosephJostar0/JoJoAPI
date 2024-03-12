package com.yupi.springbootinit.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class InterfaceInvokeRequest implements Serializable {

    /**
     * 主键
     */
    private long id;

    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}