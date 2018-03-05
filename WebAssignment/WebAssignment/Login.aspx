<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebAssignment.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login</title>
</head>
<body>
    <div style="margin-left: auto; margin-right: auto;">
        <form id="form1" runat="server">
            <asp:Login ID="Login1" runat="server" OnAuthenticate="ValidateUser"></asp:Login>
        </form>
    </div>
</body>
</html>
