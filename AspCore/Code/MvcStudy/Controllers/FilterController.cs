using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcStudy.Filters;
namespace MvcStudy.Controllers
{
    public class FilterController : Controller
    {
        // GET: Filter
        [MyAuthorization]
        [MyAction]
        public ActionResult Index()
        {
            Response.Write("行为执行中");
            return View();
        }



    }
}