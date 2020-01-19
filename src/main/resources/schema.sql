--DROP TABLE SmsMessage IF EXISTS  ;

CREATE TABLE IF NOT EXISTS SmsMessage (
      timeStapm BIGINT PRIMARY KEY,
      id INT,
      content VARCHAR(300),
      senderNumber VARCHAR(20),
      receiverNumber VARCHAR(20)
);

