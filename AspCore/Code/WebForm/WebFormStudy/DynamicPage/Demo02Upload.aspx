<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Demo02Upload.aspx.cs" Inherits="WebFormStudy.DynamicPage.Demo02Upload" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            请选择要上传的文件
            <asp:FileUpload ID="FileUpload1" runat="server" />
            <asp:Button ID="Button1" runat="server" Text="开始上传" OnClick="Button1_Click" />
            &nbsp;&nbsp;<br />
            <asp:Literal ID="Literal1" runat="server"></asp:Literal>

        </div>
    </form>
</body>
</html>
