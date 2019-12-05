package cn.how2j;

import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class ThirdPartIndexDataApplication
{
    public static void main( String[] args )
    {
        int port = 8090;
        int eurekaServerPort = 8761;
        if(NetUtil.isUsableLocalPort(eurekaServerPort)) {
            System.err.printf("端口%d未启用，请先启动eureka服务器", eurekaServerPort);
            System.exit(1);
        }
        if(args != null && args.length != 0) {
            for (String arg: args) {
               if (arg.startsWith("port=")) {
                   String strPort = StrUtil.subAfter(arg, "port=", true);
                   if(NumberUtil.isNumber(strPort)) {
                       port = Integer.parseInt(strPort);
                   }
               }
            }
        }
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(ThirdPartIndexDataApplication.class).properties("server.port=" + port).run(args);
    }
}
