<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="WebAssignment.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        Welcome
        <asp:LoginName ID="LoginName1" runat="server" Font-Bold="true" /> <br />
        Departments: <asp:DropDownList ID="ddlDepartments" runat="server" DataSourceID="SqlDataSource1" DataTextField="DeptName" DataValueField="DeptID" AppendDataBoundItems="true" AutoPostBack="True" OnSelectedIndexChanged="ddlDepartments_SelectedIndexChanged">
            <asp:ListItem Text="--All--" Value="0" Selected="True" />
        </asp:DropDownList>
        
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:Con %>"
            SelectCommand="SELECT * FROM Departments"></asp:SqlDataSource>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" BackColor="#DEBA84" BorderColor="#DEBA84" BorderStyle="None" BorderWidth="1px" CellPadding="3" CellSpacing="2" DataKeyNames="EmpID" DataSourceID="SqlDataSource2" EnableModelValidation="True">
            <Columns>
                <asp:BoundField DataField="EmpID" HeaderText="ID" ReadOnly="True" SortExpression="EmpID" />
                <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
                <asp:BoundField DataField="DoB" HeaderText="Date of Birth" SortExpression="DoB" />
                <asp:BoundField DataField="Gender" HeaderText="Gender" SortExpression="Gender" />
            </Columns>
            <FooterStyle BackColor="#F7DFB5" ForeColor="#8C4510" />
            <HeaderStyle BackColor="#A55129" Font-Bold="True" ForeColor="White" />
            <PagerStyle ForeColor="#8C4510" HorizontalAlign="Center" />
            <RowStyle BackColor="#FFF7E7" ForeColor="#8C4510" />
            <SelectedRowStyle BackColor="#738A9C" Font-Bold="True" ForeColor="White" />
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:WebDatabaseConnectionString %>" SelectCommand="SELECT [EmpID], [Name], [DoB], [Gender] FROM [Employees] WHERE ([DeptID] = @DeptID)">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlDepartments" Name="DeptID" PropertyName="SelectedValue" Type="Int32" />
            </SelectParameters>
        </asp:SqlDataSource>
        <br /><br />
        <asp:LoginStatus ID="LoginStatus1" runat="server" />
    </div>
    </form>
</body>
</html>
