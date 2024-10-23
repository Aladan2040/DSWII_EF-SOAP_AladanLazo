package com.cibertec.DSWII_EF_SOAP_AladanLazo.repository;

import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
