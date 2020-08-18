package br.com.vinicius.door.repository;

import br.com.vinicius.door.entity.DoorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoorRepository extends JpaRepository<DoorEntity, Long> {
}
