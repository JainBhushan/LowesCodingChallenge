DROP TABLE IF EXISTS tbl_transaction_records;
  
CREATE TABLE tbl_transaction_records (
  transaction_id INT AUTO_INCREMENT  PRIMARY KEY,
  ammount double,
  transaction_time long
);

