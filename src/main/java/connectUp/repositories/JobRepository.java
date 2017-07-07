package connectUp.repositories;

import org.springframework.data.repository.CrudRepository;

import connectUp.models.Job;

public interface JobRepository extends CrudRepository<Job, Long> {

}
