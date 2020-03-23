using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;
using Models;
namespace MvcStudy.Controllers
{
    public class InvokingWebAPIController : Controller
    {
        // GET: InvokingWebAPI
        public ActionResult Index()
        {
            // 客户端对象的创建与初始化
            HttpClient client = new HttpClient();
            client.DefaultRequestHeaders.Accept.Add(
                new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            // 执行get
            HttpResponseMessage response =client.GetAsync("https://localhost:44302/api/UserInfo").Result;
            //var list =response.Content.ReadAsStringAsync();
            //var list =response.Content.ReadAsAsync<List<UserInfoModel>>().Result;
            //ViewData.Model = list;
            return View();
        }
    }
}