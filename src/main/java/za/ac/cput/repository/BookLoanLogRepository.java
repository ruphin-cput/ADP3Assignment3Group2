package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.BookLoanLog;

@Repository
public interface BookLoanLogRepository extends JpaRepository<BookLoanLog, String> {

}
