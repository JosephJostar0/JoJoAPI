package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.model.entity.Post;
import com.yupi.springbootinit.service.PostService;
import com.yupi.springbootinit.mapper.PostMapper;
import org.springframework.stereotype.Service;

/**
* @author jojo
* @description 针对表【post(帖子)】的数据库操作Service实现
* @createDate 2024-02-29 14:54:00
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService{

}




