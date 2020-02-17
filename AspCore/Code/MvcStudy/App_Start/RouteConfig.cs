using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace MvcStudy
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            // 自定义路由规则要求：小范围在前，大范围在后
            // 比如2014-1-1-1
            routes.MapRoute(
                name: "HelloWorld",
                url:"{year}-{month}-{day}-{id}",
                defaults:new 
                { 
                    controller="HelloWorld",
                    action="showWorld"
                },
                constraints: new 
                {
                    year="^\\d{4}$",
                    month="^\\d{1,2}$",
                    day="^\\d{1,2}$"
                }
                );

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );
        }
    }
}
