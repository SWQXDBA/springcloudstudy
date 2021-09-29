package com.example.springcloudstudy.FeignClients;

import com.example.springcloudstudy.models.Bill;
import com.example.springcloudstudy.models.User;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("billService")
public interface UserClients{
    @GetMapping("/billuser/{userid}")
    //@value才是${}
    Bill getBillByUserId(@PathVariable("userid") Long id);
}
