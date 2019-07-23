SELECT Name As Employee FROM Employee a WHERE 
Salary > (
    SELECT Salary FROM Employee b WHERE Id = a.ManagerId
);