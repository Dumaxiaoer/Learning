using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MvcStudy.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult loginCheck(string username,string password) {
            string result = "";
            if (username == "张三" && password == "123456")
            {
                result = "登录成功";
            }
            else {
                result = "登录失败";
            }

            return Content(result);
        }

    }
}