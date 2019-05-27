package works.weave.socks.shipping;

import com.feedzai.commons.tracing.engine.JaegerTracingEngine;
import com.feedzai.commons.tracing.engine.TraceUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;

@SpringBootApplication
public class ShippingServiceApplication {
    public static void main(String[] args) throws InterruptedException {
        TraceUtil.init(new JaegerTracingEngine.Builder()
                .withSampleRate(1)
                .withCacheMaxSize(10000)
                .withCacheDuration(Duration.ofDays(2))
                .withProcessName("Shipping Service")
                .withIp("172.31.0.10")
                .build());
        SpringApplication.run(ShippingServiceApplication.class, args);
    }
}
