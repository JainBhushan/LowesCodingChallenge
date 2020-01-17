package in.lowes.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.lowes.app.beans.TransactionData;

/**
 * The Transaction Repository
 * 
 * @author bhujain
 *
 */
@Repository
public interface TransactionDao extends JpaRepository<TransactionData, Long>, TransactionCustomDao {

}
