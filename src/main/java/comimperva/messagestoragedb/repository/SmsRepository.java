package comimperva.messagestoragedb.repository;

import comimperva.messagestoragedb.model.SmsMessage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


    @Repository
    public interface SmsRepository extends CrudRepository<SmsMessage, Long> {
        @Transactional
        @Modifying
        @Query("delete from SmsMessage where timestapm < :insertionTimestamp")
        void deleteByOldInsertionTimestamp(@Param("insertionTimestamp") long insertionTimestamp);

        @Transactional
        @Query("select s from SmsMessage s ")//where timestapm < :insertionTimestamp")
        Iterable<SmsMessage> selectOldInsertionTimestamp(@Param("insertionTimestamp") long insertionTimestamp);
    }
