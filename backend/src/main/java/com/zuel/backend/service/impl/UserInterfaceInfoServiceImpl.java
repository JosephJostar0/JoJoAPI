package com.zuel.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuel.backend.common.ErrorCode;
import com.zuel.backend.exception.BusinessException;
import com.zuel.backend.mapper.InterfaceInfoMapper;
import com.zuel.backend.mapper.UserInterfaceInfoMapper;
import com.zuel.backend.mapper.UserMapper;
import com.zuel.backend.model.entity.InterfaceInfo;
import com.zuel.backend.model.entity.User;
import com.zuel.backend.model.entity.UserInterfaceInfo;
import com.zuel.backend.service.UserInterfaceInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author jojo
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2024-03-13 14:35:07
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "num less than 0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }

    @Override
    public boolean checkAccess(String accessKey, String apiPath) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        QueryWrapper<InterfaceInfo> interfaceInfoQueryWrapper = new QueryWrapper<>();
        QueryWrapper<UserInterfaceInfo> userInterfaceInfoQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("accessKey", accessKey);
        interfaceInfoQueryWrapper.eq("url", apiPath);
        long userCount = userMapper.selectCount(userQueryWrapper);
        long interfaceCount = interfaceInfoMapper.selectCount(interfaceInfoQueryWrapper);
        if (userCount != 1 || interfaceCount != 1) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userMapper.selectOne(userQueryWrapper);
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(interfaceInfoQueryWrapper);
        userInterfaceInfoQueryWrapper.eq("userId", user.getId()).eq("interfaceInfoId", interfaceInfo.getId());
        long uiCount = userInterfaceInfoMapper.selectCount(userInterfaceInfoQueryWrapper);
        if (uiCount == 0) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(userInterfaceInfoQueryWrapper);
        return userInterfaceInfo.getLeftNum() > 0;
    }


}




