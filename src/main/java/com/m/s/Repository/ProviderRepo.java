package com.m.s.Repository;

import com.m.s.Models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepo extends JpaRepository<Provider, Long> {
}
