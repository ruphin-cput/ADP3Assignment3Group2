package za.ac.cput.repository;


import za.ac.cput.entity.BookLoanLog;

import java.util.Set;

public interface IBookLoanLogRepository extends IRepository<BookLoanLog, String>{
    public Set<BookLoanLog> getAll();
}
