DROP TABLE sms_message IF EXISTS  ;

CREATE TABLE IF NOT EXISTS sms_message (
      timestapm BIGINT PRIMARY KEY,
      id INT,
      content VARCHAR(300),
      sender_number VARCHAR(20),
      receiver_number VARCHAR(20)
);

