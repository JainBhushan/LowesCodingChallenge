package in.lowes.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents entity
 * 
 * @author bhujain
 *
 */
@Entity
@Table(name = "tbl_transaction_records")
public class TransactionData {

	/**
	 * The transactionID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionID;

	/**
	 * The ammount
	 */
	private Double ammount;
	/**
	 * The timestamp
	 */
	@Column(name = "transaction_time")
	private Long timestamp;

	/**
	 * @return the transactionID
	 */
	public Long getTransactionID() {
		return transactionID;
	}

	/**
	 * @param transactionID
	 *            the transactionID to set
	 */
	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	/**
	 * @return the ammount
	 */
	public Double getAmmount() {
		return ammount;
	}

	/**
	 * @param ammount
	 *            the ammount to set
	 */
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionData [transactionID=" + transactionID + ", ammount=" + ammount + ", timestamp=" + timestamp
				+ "]";
	}

}
