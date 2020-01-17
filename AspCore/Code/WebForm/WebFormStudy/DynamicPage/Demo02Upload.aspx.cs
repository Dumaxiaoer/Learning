using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebFormStudy.DynamicPage
{
    public partial class Demo02Upload : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            // 1.判断文件是否存在
            if (this.FileUpload1.HasFile) return;
            // 2.获取文件大小，判断是否符合设置要求（变成MB）
            double fileLength = this.FileUpload1.FileContent.Length / (1024.0 * 1024.0);
            // 获取配置文件中上传大小的限制
            double limitedLength = Convert.ToDouble(System.Configuration.ConfigurationManager.AppSettings["PhysicsObjectLength"]);
            // 变成M
            limitedLength = limitedLength / (1024.0 * 1024.0);
            // 判断实际文件大小是否符合要求
            if (fileLength > limitedLength) {
                this.Literal1.Text = "上传文件大小不能超过" + limitedLength + "MB";
                
            }
            // 3.获取文件名，判断文件扩展是否符合要求
            string fileName = this.FileUpload1.FileName;
            // 判断是否是exe
            if (fileName.Substring(fileName.LastIndexOf(".")).ToLower() == ".exe") {
                this.Literal1.Text = "上传文件不能是exe";
            }
            // 修改文件名  
            fileName = DateTime.Now.ToString("yyyyMMddhhssms")+"_"+fileName;
            // 4.获取服务器文件夹路径
            string path = Server.MapPath("~/UploadFiles");
            // 5.上传文件
            try {
                this.FileUpload1.SaveAs(path + "/" + fileName);
                this.Literal1.Text = "上传文件成功";
            }
            catch (Exception ex) {

                this.Literal1.Text = "文件上传失败" + ex.Message;
            }
        }

  
    }
}