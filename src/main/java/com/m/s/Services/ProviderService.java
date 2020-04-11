package com.m.s.Services;

import com.m.s.Exceptions.ProviderException;
import com.m.s.Models.Provider;
import com.m.s.Repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProviderService {
    @Autowired
    private ProviderRepo providerRepository;

    public List<Provider> listAll() {
        return providerRepository.findAll();
    }

    public void save(Provider provider) {
        providerRepository.save(provider);
    }

    public Provider get(long id) {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new ProviderException("No provider found with ID - " + id));
        return providerRepository.findById(id).get();
    }

    public void delete(long id) {
        providerRepository.deleteById(id);
    }
}
