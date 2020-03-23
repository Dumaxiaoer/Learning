using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Models;
using MvcStudy.Models;

namespace MvcStudy.Controllers
{
    public class UserInfoController : Controller
    {
        DbContext dbContext = new MYDBEntities();
        // GET: UserInfo
        public ActionResult Index()
        {
            MYDBEntities Mydb = new MYDBEntities();
            DbContext dbContext = new MYDBEntities();
            // 查询语法
            //var list = from sys_user in Mydb.Sys_User
            //           select sys_user;
            // 方法语法(查询所有列)
            //var list = Mydb.Sys_User.Select(u => u);
            IQueryable<Sys_User> list;
            // 查询全部
            list = from userInfo in dbContext.Set<Sys_User>()
                   select userInfo;
            // 多列
            //list = from userInfo in dbContext.Set<Sys_User>()
            //       select new UserInfoViewModel()
            //       {
            //           Account = userInfo.Account,
            //           RealName = userInfo.RealName
            //       };

            // 分页 在查询全部的基础上
            list = list.OrderByDescending(u=>u.Account).Skip(2).Take(3);

            return View(list);
        }
        /// <summary>
        /// 方法查询
        /// </summary>
        /// <returns></returns>
        public ActionResult Index2() {
            DbContext dbContext = new MYDBEntities();
            IQueryable<Sys_User> list;
            // 查询全部
            list = dbContext.Set<Sys_User>();
            // 单查询
            //list = list.Where(u => u.Account=="1014");
            // 多查询
            //list = list.Where(u => (u.Account == "1014") || (u.Account == "1015"));
            //list = list.Where(u => u.Account == "1014").Where(u=>u.RealName.Contains("燕"));
            // 查询多列
            //list = list.Select(u => new Sys_User()
            //{
            //    Account=u.Account,
            //    RealName=u.NickName
            //}); 

            return View(list);
        }
        public ActionResult Add() {

            return View();    
        }
        [HttpPost]
        public ActionResult Add(Sys_User user) {
            dbContext.Set<Sys_User>().Add(user);
            dbContext.SaveChanges();
            return Redirect(@Url.Action("Index","UserInfo"));
        }


    }
}