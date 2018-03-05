Declare @i int;

Select @i = ISNULL(max(ID),0) + 1 from Logins
-- Insert rows into table 'Logins'
INSERT INTO Logins
( -- columns to insert data into
 [ID], [Username], [Password], [CreatedDate]
)
VALUES
( -- first row: values for the columns in the list above
 @i, 'user', 'pass', GETDATE()
)
-- add more rows here
GO  
-- Select rows from a Table or View 'Logins' in schema 'dbo'
SELECT * FROM dbo.Logins	/* add search conditions here */
GO