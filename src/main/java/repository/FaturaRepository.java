package Repository;

import ENUM.StatusFatura;
import Model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    List<Fatura> findByStatusFatura(StatusFatura status);
    List<Fatura> findByClienteCpf(String cpf);
    List<Fatura> findByDataVencimentoAndStatusFatura(LocalDate data, StatusFatura status);
}