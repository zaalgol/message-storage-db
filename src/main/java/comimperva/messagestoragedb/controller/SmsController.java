package comimperva.messagestoragedb.controller;

import comimperva.messagestoragedb.model.SmsMessage;
import comimperva.messagestoragedb.repository.SmsRepository;
import comimperva.messagestoragedb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Controller
public class SmsController {
    @Autowired
    private MessageService messageService;

//    @PostConstruct
//    public void init(SmsRepository smsRepository) {
//        messageService.init(smsRepository);
//    }

    @PostMapping(path = "/getAllOldInsertions")
    public Iterable<SmsMessage> getAllOldInsertions() {
        return  messageService.getAllOldInsertions();

    }

    @PostMapping(path = "/insertPostponedMessages")
    public Iterable<SmsMessage> insertPostponedMessages(@RequestParam List<SmsMessage> messages) {
        return messageService.insertPostponedMessages( messages);
    }
}
