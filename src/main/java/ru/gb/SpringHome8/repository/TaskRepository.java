package ru.gb.SpringHome8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gb.SpringHome8.model.Task;
import ru.gb.SpringHome8.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(@Param("status")TaskStatus status);
}
