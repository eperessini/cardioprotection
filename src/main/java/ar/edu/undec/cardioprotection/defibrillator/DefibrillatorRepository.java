package ar.edu.undec.cardioprotection.defibrillator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DefibrillatorRepository extends JpaRepository<Defibrillator, Long> {
}
