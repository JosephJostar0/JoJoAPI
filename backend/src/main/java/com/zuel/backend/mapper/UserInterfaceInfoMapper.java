package com.zuel.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zuel.backend.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author jojo
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2024-03-13 14:35:07
* @Entity com.zuel.backend.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    // select interfaceInfoId, sum(totalNum) as totalNum
    //from user_interface_info
    //group by interfaceInfoId
    //order by totalNum desc
    //limit 3;
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




