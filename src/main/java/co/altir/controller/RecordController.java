package co.altir.controller;

import co.altir.dto.RecordDto;
import co.altir.model.Record;
import co.altir.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @PostMapping
    public ResponseEntity<Record> saveRecord(@RequestBody RecordDto recordDto) {
        Record record = new Record()
                .setId(recordDto.getId())
                .setValue(recordDto.getValue());
        Record savedRecord = recordService.saveRecord(record);

        return new ResponseEntity<>(savedRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Record>> findAllRecords() {
        List<Record> records = recordService.findAllRecords();

        return new ResponseEntity<>(records, HttpStatus.OK);
    }

}
