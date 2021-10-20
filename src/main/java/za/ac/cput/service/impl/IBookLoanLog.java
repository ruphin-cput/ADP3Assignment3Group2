package za.ac.cput.service.impl;

import za.ac.cput.entity.BookLoanLog;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IBookLoanLog extends IService<BookLoanLog,String> {
    public Set<BookLoanLog> getAll();
}
