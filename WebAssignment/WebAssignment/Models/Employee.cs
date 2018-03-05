using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAssignment.Models
{
    public class Employee
    {
        private int _id;
        private string _name;
        private DateTime _dob;
        private string _gender;
        private int _deptID;

        public int Id
        {
            get
            {
                return _id;
            }

            set
            {
                _id = value;
            }
        }

        public string Name
        {
            get
            {
                return _name;
            }

            set
            {
                _name = value;
            }
        }

        public DateTime Dob
        {
            get
            {
                return _dob;
            }

            set
            {
                _dob = value;
            }
        }

        public string Gender
        {
            get
            {
                return _gender;
            }

            set
            {
                _gender = value;
            }
        }

        public int DeptID
        {
            get
            {
                return _deptID;
            }

            set
            {
                _deptID = value;
            }
        }
    }
}