package iuh.fit.se.be.repositories;

import iuh.fit.se.be.entities.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    List<NhaCungCap> findByMaNCCContainingOrTenNhaCCContainingOrDiaChiContainingOrSoDienThoaiContaining(
            String ma, String ten, String diaChi, String sdt);
}
