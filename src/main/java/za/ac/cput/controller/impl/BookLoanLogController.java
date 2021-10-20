package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.BookLoanLog;
import za.ac.cput.factory.BookLoanLogFactory;
import za.ac.cput.service.impl.BookLoanLogService;

import java.util.Set;

@RestController
@RequestMapping("/loan")
public class BookLoanLogController {
    @Autowired
    private BookLoanLogService bookLoanLogService;

    @PostMapping("/create")
    public BookLoanLog create(@RequestBody BookLoanLog bookLoanLog){
        BookLoanLog newBookLoanLog = BookLoanLogFactory.createBookLoanLog(bookLoanLog.getLentFromDate(),bookLoanLog.getLentToDate(),bookLoanLog.isCheckOut());
        return bookLoanLogService.create(newBookLoanLog);
    }



    @GetMapping("/read/{bookLoanLogId}")
    public BookLoanLog read(@PathVariable String bookLoanLogId) {
        return bookLoanLogService.read(bookLoanLogId);
    }

    @PostMapping("/update")
    public BookLoanLog update(@RequestBody BookLoanLog bookLoanLog) {
        return bookLoanLogService.update(bookLoanLog);
    }

    @DeleteMapping("/delete/{bookLoanLogId}")
    public boolean delete(@PathVariable String bookLoanLogId) {
        return bookLoanLogService.delete(bookLoanLogId);
    }

    @GetMapping("/getAll")
    public Set<BookLoanLog> getAll() {
        return bookLoanLogService.getAll();
    }
}
