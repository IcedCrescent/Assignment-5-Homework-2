-- Create a new table called 'Departments' in schema 'dbo'
-- Drop the table if it already exists
IF OBJECT_ID('dbo.Departments', 'U') IS NOT NULL
DROP TABLE dbo.Departments
GO
-- Create the table in the specified schema
CREATE TABLE dbo.Departments
(
    DeptID INT NOT NULL PRIMARY KEY, -- primary key column
    DeptName [NVARCHAR](30) NOT NULL
    -- specify more columns here
);
GO

-- Insert rows into table 'Departments'
INSERT INTO Departments
( -- columns to insert data into
 [DeptID], [DeptName]
)
VALUES
( -- first row: values for the columns in the list above
 1, 'Accounting'
),
( -- second row: values for the columns in the list above
 2, 'Engineering'
),
-- add more rows here
(3, 'Human Resource'),
(4, 'Marketing')
GO

-- Select rows from a Table or View 'Departments' in schema 'dbo'
SELECT * FROM dbo.Departments
GO