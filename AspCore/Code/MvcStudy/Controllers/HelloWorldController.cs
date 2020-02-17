using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MvcStudy.Controllers
{
    public class HelloWorldController : Controller
    {
        // GET: HelloWorld
        public ActionResult Index()
        {
            // 默认使用与行为同名的视图进行显示      
            return View();
            // 自定义  将自定义页面的名称作为参数传入即可访问自定义页面
            // return View("Show");
        }
        public ActionResult ShowWorld(string id,string year) {
            ViewBag.id = year;

            return View();
        }

    }
}