package com.daniel.softmanager.persistence.repository;

import com.daniel.softmanager.persistence.entity.Task;
import com.daniel.softmanager.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "update Task t set t.finished = true where t.id = :id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
