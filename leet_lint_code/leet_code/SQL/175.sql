SELECT p.FirstName As FirstName, p.LastName As LastName, addr.City As City, addr.State AS State FROM Person p LEFT OUTER JOIN Address addr ON p.PersonId = addr.PersonId