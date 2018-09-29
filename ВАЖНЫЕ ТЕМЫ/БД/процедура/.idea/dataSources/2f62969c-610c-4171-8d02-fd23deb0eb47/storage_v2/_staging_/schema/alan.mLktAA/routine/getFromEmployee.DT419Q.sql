CREATE PROCEDURE getFromEmployee(id INT)
  BEGIN
    SELECT * FROM employee WHERE emp_id = id;
  END;

