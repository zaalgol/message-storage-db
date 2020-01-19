package comimperva.messagestoragedb.service;

import comimperva.messagestoragedb.controller.SmsController;
import comimperva.messagestoragedb.model.SmsMessage;
import comimperva.messagestoragedb.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private SmsRepository smsRepository;

//    public void init(SmsRepository smsRepository) {
//        this.smsRepository = smsRepository;
//    }

    public Iterable<SmsMessage> getAllOldInsertions() {
        long now = new Date().getTime();
        try {
            synchronized (SmsController.class) {

                Iterable<SmsMessage> messages=  smsRepository.selectOldInsertionTimestamp(now);
                smsRepository.deleteByOldInsertionTimestamp(now);
                return messages;
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    public Iterable<SmsMessage> insertPostponedMessages(List<SmsMessage> messages) {
        return smsRepository.saveAll(messages);
    }
}
