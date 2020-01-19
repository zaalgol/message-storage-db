package comimperva.messagestoragedb.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class SmsMessage extends Message {
    private String sender_number;
    private String receiver_number;
    private String content;
    private int id;

    @Id
    private long timestapm;
    public SmsMessage() {

    }

    public SmsMessage(int id) {
        setId(id);
    }

    public SmsMessage(int id, String senderNumber, String receiverNumber) {
        setId(id);
        this.sender_number = senderNumber;
        this.receiver_number = receiverNumber;
    }
}