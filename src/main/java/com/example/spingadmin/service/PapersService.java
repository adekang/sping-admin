package com.example.spingadmin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spingadmin.entity.Papers;
import com.example.spingadmin.mapper.PapersMapper;
import org.springframework.stereotype.Service;

@Service
public class PapersService extends ServiceImpl<PapersMapper, Papers> {
}
