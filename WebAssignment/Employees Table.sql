-- Create a new table called 'Employees' in schema 'dbo'
-- Drop the table if it already exists
IF OBJECT_ID('dbo.Employees', 'U') IS NOT NULL
DROP TABLE dbo.Employees
GO
-- Create the table in the specified schema
CREATE TABLE dbo.Employees
(
    EmpID INT NOT NULL PRIMARY KEY, -- primary key column
    Name [NVARCHAR](50) NOT NULL,
    DoB [DATE] NOT NULL,
    Gender [NVARCHAR](1) NOT NULL CHECK (Gender = 'M' OR Gender = 'F'),
    DeptID INT NOT NULL,
    CONSTRAINT FK_Department FOREIGN KEY (DeptID) REFERENCES Departments(DeptID)
);
GO

-- Insert rows into table 'Employees'
INSERT INTO Employees
( -- columns to insert data into
 [EmpID], [Name], [DoB], [Gender], [DeptID]
)
VALUES
( -- first row: values for the columns in the list above
 1, 'Jenny', '1990-06-12', 'F', 1
),
( -- second row: values for the columns in the list above
 2, 'Johnson', '1985-2-28', 'M', 2
),
(3, 'Lydia', '1989-12-03', 'F', 2),
(4, 'Tom', '1992-9-6', 'M', 4)
GO

-- Select rows from a Table or View 'Employees' in schema 'dbo'
SELECT * FROM dbo.Employees
GO