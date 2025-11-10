package com.demo.distributed.jobs.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InstanceInfoService {

    @Value("${server.port}")
    private int port;

    public int getPort() {
        return port;
    }
}
