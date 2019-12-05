package cn.how2j;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication
{
    public static void main( String[] args )
    {
        int defaultPort = 8761;
        if (!NetUtil.isUsableLocalPort(defaultPort)) {
            System.err.printf("端口%d已经被占用，无法启动", defaultPort);
            System.exit(1);
        }
        new SpringApplicationBuilder(EurekaServerApplication.class)
                .properties("server.port=" + defaultPort).run(args);
    }
}
