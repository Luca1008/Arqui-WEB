package main.monopatines.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {
}