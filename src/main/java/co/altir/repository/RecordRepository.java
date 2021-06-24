package co.altir.repository;

import co.altir.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, String> {
}
