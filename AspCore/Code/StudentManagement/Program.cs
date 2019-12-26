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
            // ������վ�йܵ����̣�ͨ��������������Ŀ�����л�ȡhttp����ܵ�
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            // Ԥ������ڷ�������
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    // ����userstartup ��������������Startup�ļ��������ֲ���
                    // �ò���Ϊ�м����������ʽ
                    webBuilder.UseStartup<Startup>();
                });
    }
}
