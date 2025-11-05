package com.example.vaultdemo.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class SecretService {

    private final VaultTemplate vaultTemplate;

    public SecretService(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    public Map<String, Object> readSecret(String path) {
        VaultKeyValueOperations kv = vaultTemplate.opsForKeyValue("secret", KeyValueBackend.KV_2);
        VaultResponseSupport<Map> resp = kv.get(path, Map.class);
        return resp == null ? null : resp.getData();
    }

    public void writeSecret(String path, Map<String, Object> data) {
        VaultKeyValueOperations kv = vaultTemplate.opsForKeyValue("secret", KeyValueBackend.KV_2);
        kv.put(path, data);
    }
}
