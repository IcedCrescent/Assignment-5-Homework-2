CREATE PROCEDURE [dbo].[Validate_User]
      @Username NVARCHAR(20),
      @Password NVARCHAR(20)
AS
BEGIN
      SET NOCOUNT ON;
      DECLARE @UserId INT, @LastLoginDate DATETIME
     
      SELECT @UserId = ID, @LastLoginDate = LastLoginDate
      FROM Logins WHERE Username = @Username AND [Password] = @Password
     
      IF @UserId IS NOT NULL
      BEGIN
            UPDATE Logins
            SET LastLoginDate = GETDATE()
            WHERE ID = @UserId
            SELECT @UserId [UserId] -- User Valid
      END
      ELSE
      BEGIN
            SELECT -1 -- User invalid.
      END
END
