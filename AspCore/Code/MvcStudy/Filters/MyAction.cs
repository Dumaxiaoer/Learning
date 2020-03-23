using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
namespace MvcStudy.Filters
{
    public class MyAction:ActionFilterAttribute
    {
        /// <summary>
        /// 表示行为执行前，需要处理的代码
        /// </summary>
        /// <param name="filterContext"></param>
        public override void OnActionExecuting(ActionExecutingContext filterContext)
        {
            filterContext.HttpContext.Response.Write("ing<br>");

            
        }
        /// <summary>
        /// 行为执行后，需要处理的代码
        /// </summary>
        /// <param name="filterContext"></param>
        public override void OnActionExecuted(ActionExecutedContext filterContext)
        {
            filterContext.HttpContext.Response.Write("ed<br>");
        }
    }
}