using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Models;
namespace WebAPI.Controllers
{
    public class UserInfoController : ApiController
    {
        // GET: api/UserInfo
        // 使用method=get的方式请求url=aip/userinfo，则这个方法会被调用执行
        // 查询所有信息
        public IEnumerable<UserInfoModel> Get()
        {
            List<UserInfoModel> list = new List<UserInfoModel>();
            list.Add(new UserInfoModel()
            {
                Id = 1,
                Name = "孙笑川"
            });
            list.Add(new UserInfoModel()
            {
                Id = 2,
                Name = "蔡徐坤"
            });
            list.Add(new UserInfoModel()
            {
                Id = 3,
                Name = "天皇"
            });

            return list;
        }

        // GET: api/UserInfo/5
        // 查询单条信息 5为条件
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/UserInfo
        // 增加
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/UserInfo/5
        // 修改操作 
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/UserInfo/5
        // 删除
        public void Delete(int id)
        {
        }
    }
}
