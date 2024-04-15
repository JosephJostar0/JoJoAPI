package com.zuel.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuel.backend.common.ErrorCode;
import com.zuel.backend.exception.BusinessException;
import com.zuel.backend.mapper.InterfaceInfoMapper;
import com.zuel.backend.model.entity.InterfaceInfo;
import com.zuel.backend.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author jojo
 * @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
 * @createDate 2024-02-29 14:44:57
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        Long id = interfaceInfo.getId();
        Date createTime = interfaceInfo.getCreateTime();
        Date updateTime = interfaceInfo.getUpdateTime();
        Integer isDeleted = interfaceInfo.getIsDeleted();
        String apiName = interfaceInfo.getApiName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        Long userId = interfaceInfo.getUserId();

        if (add) {
            if (StringUtils.isAnyBlank(apiName, url)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if(StringUtils.isNotBlank(apiName) && apiName.length() > 50){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




