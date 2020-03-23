using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MvcStudy.Filters
{
    public class MyAuthorization:AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            // 如果保留如下代码，则会运行.net framework定义好的身份验证，如果希望自定义
            // 身份验证，则删除如下代码
            //base.OnAuthorization(filterContext);
            // 如果希望跳转到另外一个页面，需要使用Result,而不是使用Response.Redirect();
            //filterContext.Result = new RedirectResult(UrlHelper.GenerateUrl("","",""));
            // 获取路由数据，当前上下文匹配到路由规则后，得到的一个对象
            //filterContext.RouteData
            // 获取上下文
            filterContext.HttpContext.Response.Write("fuck u");

        }




    }
}