package in.lowes.app.beans;

/**
 * 
 * This class is used for store aggregate transaction records
 * 
 * @author bhujain
 *
 */
public class TransactionAggregateRecords {

	/**
	 * The sumAmt
	 */
	private Double sumAmt;
	/**
	 * The avgAmt
	 */
	private Double avgAmt;
	/**
	 * The maxAmt
	 */
	private Double maxAmt;
	/**
	 * The minAmt
	 */
	private Double minAmt;
	/**
	 * totalNoOfTransaction
	 */
	private Long totalNoOfTransaction;

	/**
	 * @return the sumAmt
	 */
	public Double getSumAmt() {
		return sumAmt;
	}

	/**
	 * @param sumAmt
	 *            the sumAmt to set
	 */
	public void setSumAmt(Double sumAmt) {
		this.sumAmt = sumAmt;
	}

	/**
	 * @return the avgAmt
	 */
	public Double getAvgAmt() {
		return avgAmt;
	}

	/**
	 * @param avgAmt
	 *            the avgAmt to set
	 */
	public void setAvgAmt(Double avgAmt) {
		this.avgAmt = avgAmt;
	}

	/**
	 * @return the maxAmt
	 */
	public Double getMaxAmt() {
		return maxAmt;
	}

	/**
	 * @param maxAmt
	 *            the maxAmt to set
	 */
	public void setMaxAmt(Double maxAmt) {
		this.maxAmt = maxAmt;
	}

	/**
	 * @return the minAmt
	 */
	public Double getMinAmt() {
		return minAmt;
	}

	/**
	 * @param minAmt
	 *            the minAmt to set
	 */
	public void setMinAmt(Double minAmt) {
		this.minAmt = minAmt;
	}

	/**
	 * @return the totalNoOfTransaction
	 */
	public Long getTotalNoOfTransaction() {
		return totalNoOfTransaction;
	}

	/**
	 * @param totalNoOfTransaction
	 *            the totalNoOfTransaction to set
	 */
	public void setTotalNoOfTransaction(Long totalNoOfTransaction) {
		this.totalNoOfTransaction = totalNoOfTransaction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionAggregateRecords [sumAmt=" + sumAmt + ", avgAmt=" + avgAmt + ", maxAmt=" + maxAmt
				+ ", minAmt=" + minAmt + ", totalNoOfTransaction=" + totalNoOfTransaction + "]";
	}

}
