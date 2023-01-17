package com.mupra.task.mapper;

import com.mupra.task.dto.PublisherDto;
import com.mupra.task.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
    Publisher dtoToModel(PublisherDto publisherDto);
}
