package com.ydh.iotauto.feign;

import com.ydh.iotauto.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name = "data-operation")
public interface IUserFeign {

    @GetMapping("/query/user/{name}")
    User getInfoByName (@PathVariable(value = "name") String name) ;
}
