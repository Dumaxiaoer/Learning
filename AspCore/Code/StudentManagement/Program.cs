using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace StudentManagement
{
    public class Program
    {
        public static void Main(string[] args)
        {
            // 启动网站托管到进程，通过编译器生成项目，运行获取http请求管道
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            // 预设参数在服务器上
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    // 调用userstartup ，可以让我们在Startup文件中做各种操作
                    // 该步骤为中间件的体现形式
                    webBuilder.UseStartup<Startup>();
                });
    }
}
