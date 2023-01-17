package com.mupra.task.service.impl;

import com.mupra.task.base.service.impl.BaseServiceImpl;
import com.mupra.task.entity.Publisher;
import com.mupra.task.repository.PublisherRepository;
import com.mupra.task.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl extends BaseServiceImpl<Publisher, PublisherRepository> implements PublisherService {
    public PublisherServiceImpl(PublisherRepository repository) {
        super(repository);
    }
}