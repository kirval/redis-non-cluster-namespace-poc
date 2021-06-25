package co.altir.service;

import co.altir.model.Record;
import co.altir.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    public List<Record> findAllRecords() {
        List<Record> records = new ArrayList<>();
        recordRepository.findAll().forEach(records::add);

        return records;
    }

}
