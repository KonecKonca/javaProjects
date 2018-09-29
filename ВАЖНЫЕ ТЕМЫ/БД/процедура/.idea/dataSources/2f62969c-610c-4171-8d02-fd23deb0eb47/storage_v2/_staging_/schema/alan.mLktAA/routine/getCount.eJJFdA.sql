CREATE PROCEDURE  getCountBranch(OUT returnVar INT)  /* out значит что это возвращаемое значение */
  BEGIN
    SELECT count(*) into returnVar FROM employee;
  END;

