package com.mupra.task.mapper;

import com.mupra.task.dto.WriterDto;
import com.mupra.task.entity.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WriterMapper {
    WriterMapper INSTANCE = Mappers.getMapper(WriterMapper.class);
    Writer dtoToModel(WriterDto writerDto);
}
