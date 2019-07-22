CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE p1 INT;
  DECLARE p2 INT;
  
  IF (N < 1) 
    THEN SET p1 = 0, p2 = 0;
  ELSE
    SET p1 = N - 1, p2 = 1;
  END IF;
  
  RETURN (
      # Write your MySQL query statement below.
      SELECT
          IFNULL (
              (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT p2 OFFSET p1)
              , NULL)  AS getNthHighestSalary
  );
END