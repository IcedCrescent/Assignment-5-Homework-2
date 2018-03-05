using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAssignment
{
    public partial class Home : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!this.Page.User.Identity.IsAuthenticated)
            {
                FormsAuthentication.RedirectToLoginPage();
                SqlDataSource2.DataBind();
            }
        }

        protected void ddlDepartments_SelectedIndexChanged(object sender, EventArgs e)
        {
            UpdateDatasource();
        }

        private void UpdateDatasource()
        {
            if (ddlDepartments.SelectedValue.Equals("0"))
            {
                SqlDataSource2.SelectCommand = "SELECT * FROM Employees";
                SqlDataSource2.Select(DataSourceSelectArguments.Empty);
                SqlDataSource2.DataBind();
                GridView1.DataBind();
            }
        }
    }
}