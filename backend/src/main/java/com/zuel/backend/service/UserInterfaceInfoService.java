package com.zuel.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuel.backend.model.entity.UserInterfaceInfo;

/**
* @author jojo
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-03-13 14:35:07
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo interfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);
}
