package com.mupra.task.service.impl;

import com.mupra.task.base.service.impl.BaseServiceImpl;
import com.mupra.task.entity.Writer;
import com.mupra.task.repository.WriterRepository;
import com.mupra.task.service.WriterService;
import org.springframework.stereotype.Service;

@Service
public class WriterServiceImpl extends BaseServiceImpl<Writer, WriterRepository> implements WriterService {
    public WriterServiceImpl(WriterRepository repository) {
        super(repository);
    }
}