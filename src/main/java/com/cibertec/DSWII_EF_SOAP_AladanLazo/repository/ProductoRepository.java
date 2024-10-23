package com.cibertec.DSWII_EF_SOAP_AladanLazo.repository;

import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
