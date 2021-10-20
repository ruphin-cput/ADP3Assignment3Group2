package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.BookLoanLog;
import za.ac.cput.repository.BookLoanLogRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookLoanLogService implements IBookLoanLog{

    private static BookLoanLogService service = null;
    @Autowired
    private BookLoanLogRepository repository;



    @Override
    public BookLoanLog create(BookLoanLog bookLoanLog) {
        return this.repository.save(bookLoanLog);
    }

    @Override
    public BookLoanLog read(String bookLoanLogId) {
        return this.repository.findById(bookLoanLogId).orElse(null);
    }

    @Override
    public BookLoanLog update(BookLoanLog bookLoanLog) {
        if(this.repository.existsById(bookLoanLog.getBookLoanLogId()))
            return this.repository.save(bookLoanLog);

         return null;

    }

    @Override
    public boolean delete(String bookLoanLogId) {
        this.repository.deleteById(bookLoanLogId);
        if(this.repository.existsById(bookLoanLogId))
            return false;
        else
            return true;
    }

    @Override
    public Set<BookLoanLog> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
