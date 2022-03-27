package com.ydh.iotdeviceop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydh.iotdeviceop.dao.IDeviceDataDao;
import com.ydh.iotdeviceop.entity.DeviceDataEntity;
import com.ydh.iotdeviceop.service.IDeviceDataService;
import com.ydh.iotdeviceop.service.IDeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceDataServiceImpl extends ServiceImpl<IDeviceDataDao, DeviceDataEntity> implements IDeviceDataService {
}
