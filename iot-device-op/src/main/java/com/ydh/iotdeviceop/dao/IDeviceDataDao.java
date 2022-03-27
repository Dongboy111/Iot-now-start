package com.ydh.iotdeviceop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ydh.iotdeviceop.entity.DeviceDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface IDeviceDataDao extends BaseMapper<DeviceDataEntity> {
}
